package u.svinmike.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import u.svinmike.di.DependencyManager;
import u.svinmike.mvp.model.repository.ImagesRepository;
import u.svinmike.mvp.view.SlideShowView;

/**
 * Date: 02.02.2017
 * Time: 23:56
 *
 * @author Savin Mikhail
 */
@InjectViewState
public class SlideShowPresenter extends MvpPresenter<SlideShowView> {
	@Inject
	ImagesRepository imagesRepository;
	private Disposable subscribe;

	public SlideShowPresenter() {
		DependencyManager.getAppComponent().inject(this);

		getViewState().showTotalProgress();
		imagesRepository.getAll()
				.toObservable()
				.flatMapIterable(images -> images)
				.filter(image -> !image.isThumb())
				.toList()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(images -> {
					getViewState().showImages(images);
					getViewState().hideTotalProgress();

					startTimer();
				});
	}

	public void startTimer() {
		if (subscribe != null) {
			subscribe.dispose();
		}

		subscribe = Observable.interval(5, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(aLong -> {
					getViewState().slideToNext();
				});
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		subscribe.dispose();
	}
}

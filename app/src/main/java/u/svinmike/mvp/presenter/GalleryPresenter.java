package u.svinmike.mvp.presenter;

import android.graphics.Rect;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import u.svinmike.di.DependencyManager;
import u.svinmike.mvp.model.data.Image;
import u.svinmike.mvp.model.repository.ImagesRepository;
import u.svinmike.mvp.view.GalleryView;

/**
 * Date: 02.02.2017
 * Time: 16:15
 *
 * @author Savin Mikhail
 */
@InjectViewState
public class GalleryPresenter extends MvpPresenter<GalleryView> {

	@Inject
	ImagesRepository imagesRepository;
	private boolean previewVisible;


	public GalleryPresenter() {
		DependencyManager.getAppComponent().inject(this);

		getViewState().showTotalProgress();
		imagesRepository.getAll()
				.toObservable()
				.flatMapIterable(images -> images)
				.filter(Image::isThumb)
				.toList()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(images -> {
					getViewState().showImages(images);
					getViewState().hideTotalProgress();
				});
	}

	public void userClickOnImage(final Image image, final Rect rect, final int pos) {
		if (previewVisible) {
			hidePreview();
			return;
		}

		getViewState().showPreview(image, rect, pos);
		previewVisible = true;
	}

	private void hidePreview() {
		previewVisible = false;
		getViewState().hidePreview();
	}

	public void userClickBack() {
		if(previewVisible){
			hidePreview();
		} else {
			getViewState().back();
		}
	}
}

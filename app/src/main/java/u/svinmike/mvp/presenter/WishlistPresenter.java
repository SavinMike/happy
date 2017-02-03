package u.svinmike.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import u.svinmike.di.DependencyManager;
import u.svinmike.mvp.model.repository.WishlistRepository;
import u.svinmike.mvp.view.WishlistView;

/**
 * Date: 02.02.2017
 * Time: 11:37
 *
 * @author Savin Mikhail
 */
@InjectViewState
public class WishlistPresenter extends MvpPresenter<WishlistView> {
	@Inject
	WishlistRepository wishlistRepository;

	public WishlistPresenter () {
		DependencyManager.getAppComponent().inject(this);
		updateList();
	}

	public void updateList() {
		getViewState().showTotalProgress();
		wishlistRepository.getAll()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(wishLists -> {
					getViewState().hideTotalProgress();
					getViewState().showWishList(wishLists);
				});

	}
}

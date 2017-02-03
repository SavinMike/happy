package u.svinmike.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import u.svinmike.mvp.model.repository.WishlistRepository;
import u.svinmike.mvp.view.WishListDetailView;

/**
 * Date: 03.02.2017
 * Time: 16:45
 *
 * @author Savin Mikhail
 */
@InjectViewState
public class WishlistDetailPresenter extends MvpPresenter<WishListDetailView> {


	@Inject
	WishlistRepository wishlistRepository;

	public WishlistDetailPresenter(int id) {
		getViewState().startLoadingWishList();

		wishlistRepository.getWishListDetail(id)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(wishList -> {
					getViewState().finishLoadingWishList();
					getViewState().showWishList(wishList);
				});
	}
}

package u.svinmike.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import u.svinmike.mvp.model.data.WishList;

/**
 * Date: 03.02.2017
 * Time: 16:46
 *
 * @author Savin Mikhail
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface WishListDetailView extends MvpView {
	void showWishList(WishList wishList);

	void startLoadingWishList();

	void finishLoadingWishList();
}

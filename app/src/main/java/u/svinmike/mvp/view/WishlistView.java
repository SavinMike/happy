package u.svinmike.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import u.svinmike.mvp.model.data.WishList;

/**
 * Date: 02.02.2017
 * Time: 11:37
 *
 * @author Savin Mikhail
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface WishlistView extends MvpView {
	void showTotalProgress();

	void showWishList(List<WishList> wishLists);

	void hideTotalProgress();
}

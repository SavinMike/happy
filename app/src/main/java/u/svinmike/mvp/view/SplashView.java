package u.svinmike.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Date: 01.02.2017
 * Time: 18:36
 *
 * @author Savin Mikhail
 */
@StateStrategyType(OneExecutionStateStrategy.class)
public interface SplashView extends MvpView {

	void showMainScreen();
}

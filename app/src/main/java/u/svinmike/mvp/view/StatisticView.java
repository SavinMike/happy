package u.svinmike.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.Date;
import java.util.List;
import java.util.Map;

import u.svinmike.mvp.model.data.Statistic;

/**
 * Date: 03.02.2017
 * Time: 22:51
 *
 * @author Savin Mikhail
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface StatisticView extends MvpView {

	void showStatistic(List<Statistic> statistics);
}

package u.svinmike.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import u.svinmike.mvp.model.data.Image;

/**
 * Date: 02.02.2017
 * Time: 23:56
 *
 * @author Savin Mikhail
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface SlideShowView extends MvpView {
	void showTotalProgress();

	void showImages(List<Image> images);

	void hideTotalProgress();

	@StateStrategyType(AddToEndStrategy.class)
	void slideToNext();
}

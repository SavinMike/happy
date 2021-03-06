package u.svinmike.mvp.view;

import android.graphics.Rect;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import u.svinmike.mvp.model.data.Image;

/**
 * Date: 02.02.2017
 * Time: 16:16
 *
 * @author Savin Mikhail
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface GalleryView extends MvpView {
	void showTotalProgress();

	void hideTotalProgress();

	void showImages(List<Image> images);

	void showPreview(Image image, Rect rect, int pos);

	void hidePreview();

	@StateStrategyType(OneExecutionStateStrategy.class)
	void back();

}

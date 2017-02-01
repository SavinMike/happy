package u.svinmike.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import u.svinmike.mvp.view.SplashView;

/**
 * Date: 01.02.2017
 * Time: 18:36
 *
 * @author Savin Mikhail
 */
@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

	public SplashPresenter () {
		Observable.timer(3, TimeUnit.SECONDS)
				.subscribe(aLong -> {
					getViewState().showMainScreen();
				});
	}
}

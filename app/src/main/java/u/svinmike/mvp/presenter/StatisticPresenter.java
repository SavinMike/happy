package u.svinmike.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import u.svinmike.di.DependencyManager;
import u.svinmike.mvp.model.repository.StatisticRepository;
import u.svinmike.mvp.view.StatisticView;

/**
 * Date: 03.02.2017
 * Time: 22:50
 *
 * @author Savin Mikhail
 */
@InjectViewState
public class StatisticPresenter extends MvpPresenter<StatisticView> {

	@Inject
	StatisticRepository statisticRepository;

	public StatisticPresenter() {
		DependencyManager.getAppComponent().inject(this);
		statisticRepository.provideStatistic()
				.subscribe(getViewState()::showStatistic);
	}
}

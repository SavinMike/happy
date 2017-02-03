package u.svinmike.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import u.svinmike.R;
import u.svinmike.mvp.model.data.Statistic;
import u.svinmike.mvp.presenter.StatisticPresenter;
import u.svinmike.mvp.view.StatisticView;
import u.svinmike.ui.adapter.statistic.StatisticAdapter;

/**
 * Date: 01.02.2017
 * Time: 19:07
 *
 * @author Savin Mikhail
 */
public class StatisticFragment extends NavigationFragment implements StatisticView {

	@BindView(R.id.fragment_statistic_recyclerView)
	RecyclerView recyclerView;
	@InjectPresenter
	StatisticPresenter statisticPresenter;
	private StatisticAdapter adapter;

	@Override
	public int getTheme() {
		return R.style.AppTheme_Statistic;
	}

	@Override
	protected int getContainerViewId() {
		return R.layout.fragment_statistic;
	}

	@Override
	protected String getTitle() {
		return getString(R.string.menu_statistic);
	}

	@Override
	public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		adapter = new StatisticAdapter(getContext());
		recyclerView.setAdapter(adapter);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		adapter.close();
	}

	@Override
	public void showStatistic(final List<Statistic> statistics) {
		adapter.setCollection(statistics);
	}
}

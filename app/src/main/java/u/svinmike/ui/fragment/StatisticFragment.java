package u.svinmike.ui.fragment;

import u.svinmike.R;

/**
 * Date: 01.02.2017
 * Time: 19:07
 *
 * @author Savin Mikhail
 */
public class StatisticFragment extends NavigationFragment {
	@Override
	protected int getTheme() {
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
}

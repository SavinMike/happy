package u.svinmike.ui.activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;

import butterknife.BindView;
import u.svinmike.R;
import u.svinmike.ui.fragment.GalleryFragment;
import u.svinmike.ui.fragment.NavigationFragment;
import u.svinmike.ui.fragment.StatisticFragment;
import u.svinmike.ui.fragment.WishListFragment;

/**
 * Date: 01.02.2017
 * Time: 18:38
 *
 * @author Savin Mikhail
 */
public class MainActivity extends BaseActivity {

	@BindView(R.id.activity_main_containerFrameLayout)
	FrameLayout containerFrameLayout;
	@BindView(R.id.activity_main_bottomBar)
	BottomBar bottomNavigation;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bottomNavigation.setOnTabSelectListener(tabId -> {
			NavigationFragment newFragment;
			switch (tabId) {
				case R.id.action_gallery:
					newFragment = new GalleryFragment();
					break;
				case R.id.action_wish_list:
					newFragment = new WishListFragment();
					break;
				case R.id.action_statistic:
					newFragment = new StatisticFragment();
					break;
				default:
					return;
			}

			while (getSupportFragmentManager().getBackStackEntryCount() != 0) {
				getSupportFragmentManager().popBackStackImmediate();
			}

			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
				setTheme(newFragment.getTheme());
				TypedValue typedValue = new TypedValue();
				getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
				int color = typedValue.data;
				getWindow().setStatusBarColor(color);
			}

			changeFragment(newFragment, String.valueOf(tabId), true, true);
		});
	}

	public void changeFragment(final Fragment fragment, final String tag, final boolean add, boolean animate) {
		@SuppressLint("CommitTransaction")
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		if (animate) {
			fragmentTransaction.setCustomAnimations(R.anim.fast_fade_in, R.anim.fast_fade_out);
		}
		Fragment fragmentById = getSupportFragmentManager().findFragmentById(R.id.activity_main_containerFrameLayout);
		if (fragmentById != null) {
			fragmentTransaction.detach(fragmentById);
		}

		if (getSupportFragmentManager().findFragmentByTag(tag) != null && !add) {
			fragmentTransaction.attach(fragment).commitNowAllowingStateLoss();
		} else {
			fragmentTransaction
					.add(R.id.activity_main_containerFrameLayout, fragment, tag)
					.commitNowAllowingStateLoss();
		}
	}

	@Override
	public void onBackPressed() {
		Fragment fragmentById = getSupportFragmentManager().findFragmentById(R.id.activity_main_containerFrameLayout);
		if (fragmentById != null && fragmentById instanceof HandleBack) {
			if (((HandleBack) fragmentById).onBackPressed()) {
				return;
			}
		}
		super.onBackPressed();
	}

	public interface HandleBack {
		boolean onBackPressed();
	}
}

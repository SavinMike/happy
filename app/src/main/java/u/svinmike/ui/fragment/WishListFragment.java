package u.svinmike.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import u.svinmike.R;

/**
 * Date: 01.02.2017
 * Time: 19:07
 *
 * @author Savin Mikhail
 */
public class WishListFragment extends NavigationFragment {
	@BindView(R.id.fragment_wishlist_recyclerView)
	RecyclerView recyclerView;

	@Override
	protected int getTheme() {
		return R.style.AppTheme_WishList;
	}

	@Override
	protected int getContainerViewId() {
		return R.layout.fragment_wishlist;
	}


	@Override
	protected String getTitle() {
		return getString(R.string.menu_wishList);
	}

	@Override
	public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

	}
}

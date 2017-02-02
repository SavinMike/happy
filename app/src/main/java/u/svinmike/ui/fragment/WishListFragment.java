package u.svinmike.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.plugins.ProgressViewPlugin;
import com.arellomobile.plugins.base.CompositionPlugin;

import java.util.List;

import butterknife.BindView;
import u.svinmike.R;
import u.svinmike.mvp.model.data.WishList;
import u.svinmike.mvp.presenter.WishlistPresenter;
import u.svinmike.mvp.view.WishlistView;
import u.svinmike.ui.adapter.WishlistAdapter;

/**
 * Date: 01.02.2017
 * Time: 19:07
 *
 * @author Savin Mikhail
 */
public class WishListFragment extends NavigationFragment implements WishlistView {
	@InjectPresenter
	WishlistPresenter wishlistPresenter;

	@BindView(R.id.fragment_wishlist_recyclerView)
	RecyclerView recyclerView;
	private ProgressViewPlugin progressViewPlugin;
	private WishlistAdapter adapter;

	@Override
	protected void initPlugins(final CompositionPlugin compositionPlugin) {
		super.initPlugins(compositionPlugin);
		progressViewPlugin = new ProgressViewPlugin(R.id.fragment_wishlist_totalProgressBar, R.id.fragment_wishlist_recyclerView);
		compositionPlugin.attach(progressViewPlugin);
	}

	@Override
	public int getTheme() {
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
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(layoutManager);
		DividerItemDecoration decor = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
		recyclerView.addItemDecoration(decor);
		adapter = new WishlistAdapter(getContext());
		adapter.setOnItemClickListener((view1, position) -> {
//			WishlistDetailActivity.startActivity(c)
		});
		recyclerView.setAdapter(adapter);
	}

	@Override
	public void showTotalProgress() {
		progressViewPlugin.showProgress();
	}

	@Override
	public void showWishList(final List<WishList> wishLists) {
		adapter.setCollection(wishLists);
	}

	@Override
	public void hideTotalProgress() {
		progressViewPlugin.hideProgress();
	}
}

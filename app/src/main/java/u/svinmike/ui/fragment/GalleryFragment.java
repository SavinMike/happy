package u.svinmike.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import u.svinmike.R;
import u.svinmike.ui.adapter.GalleryAdapter;

/**
 * Date: 01.02.2017
 * Time: 19:06
 *
 * @author Savin Mikhail
 */
public class GalleryFragment extends NavigationFragment {
	@BindView(R.id.fragment_gallery_recyclerView)
	RecyclerView recyclerView;

	@Override
	protected int getTheme() {
		return R.style.AppTheme_Gallery;
	}

	@Override
	protected int getContainerViewId() {
		return R.layout.fragment_gallery;
	}

	@Override
	protected String getTitle() {
		return getString(R.string.menu_gallery);
	}

	@Override
	public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
		recyclerView.setAdapter(new GalleryAdapter(getContext()));
	}
}

package u.svinmike.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.plugins.ProgressViewPlugin;
import com.arellomobile.plugins.base.CompositionPlugin;

import java.util.List;

import butterknife.BindView;
import u.svinmike.R;
import u.svinmike.mvp.model.data.Image;
import u.svinmike.mvp.presenter.GalleryPresenter;
import u.svinmike.mvp.view.GalleryView;
import u.svinmike.ui.adapter.GalleryAdapter;

/**
 * Date: 01.02.2017
 * Time: 19:06
 *
 * @author Savin Mikhail
 */
public class GalleryFragment extends NavigationFragment implements GalleryView {
	@BindView(R.id.fragment_gallery_recyclerView)
	RecyclerView recyclerView;
	private ProgressViewPlugin progressViewPlugin;
	private GalleryAdapter galleryAdapter;

	@InjectPresenter
	GalleryPresenter galleryPresenter;

	@Override
	public int getTheme() {
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
		galleryAdapter = new GalleryAdapter(getContext());
		recyclerView.setAdapter(galleryAdapter);
	}

	@Override
	protected void initPlugins(final CompositionPlugin compositionPlugin) {
		super.initPlugins(compositionPlugin);
		progressViewPlugin = new ProgressViewPlugin(R.id.fragment_gallery_totalProgressBar, R.id.fragment_gallery_recyclerView);
		compositionPlugin.attach(progressViewPlugin);
	}

	@Override
	public void showTotalProgress() {
		progressViewPlugin.showProgress();
	}

	@Override
	public void hideTotalProgress() {
		progressViewPlugin.hideProgress();
	}

	@Override
	public void showImages(final List<Image> images) {
		galleryAdapter.setCollection(images);
	}
}

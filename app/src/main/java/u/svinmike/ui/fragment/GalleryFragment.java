package u.svinmike.ui.fragment;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.plugins.ProgressViewPlugin;
import com.arellomobile.plugins.base.CompositionPlugin;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import u.svinmike.R;
import u.svinmike.mvp.model.data.Image;
import u.svinmike.mvp.presenter.GalleryPresenter;
import u.svinmike.mvp.view.GalleryView;
import u.svinmike.ui.activity.MainActivity;
import u.svinmike.ui.activity.SlideShowActivity;
import u.svinmike.ui.adapter.gallery.GalleryAdapter;

/**
 * Date: 01.02.2017
 * Time: 19:06
 *
 * @author Savin Mikhail
 */
public class GalleryFragment extends NavigationFragment implements GalleryView, MainActivity.HandleBack {
	@BindView(R.id.fragment_gallery_additionalRootFrameLayout)
	FrameLayout additionalRoot;
	@BindView(R.id.fragment_gallery_recyclerView)
	RecyclerView recyclerView;
	@BindView(R.id.fragment_gallery_clickImageView)
	ImageView imageView;
	@BindView(R.id.fragment_gallery_categoryTextView)
	TextView categoryTextView;
	@BindView(R.id.fragment_gallery_dateTextView)
	TextView dateTextView;
	@BindView(R.id.fragment_gallery_slideshowButton)
	Button slideshowButton;
	@BindView(R.id.fragment_gallery_clickRootView)
	CardView clickRootView;
	@BindView(R.id.fragment_gallery_descriptionRelativeLayout)
	RelativeLayout descriptionRelativeLayout;
	@BindView(R.id.fragment_gallery_clickBackgroundRelativeLayout)
	RelativeLayout clickBackgroundRelativeLayout;

	private ProgressViewPlugin progressViewPlugin;
	private GalleryAdapter galleryAdapter;

	@InjectPresenter
	GalleryPresenter galleryPresenter;
	private boolean backPress;

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
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		galleryAdapter = new GalleryAdapter(getContext());

		galleryAdapter.setOnImageClick((image, rect, pos) -> galleryPresenter.userClickOnImage(image, rect, pos));

		slideshowButton.setOnClickListener(v -> SlideShowActivity.startActivity(getContext(), (Integer) v.getTag(R.id.position)));
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

	@Override
	public void showPreview(final Image image, final Rect rect, final int pos) {
		slideshowButton.setTag(R.id.position, pos);
		Glide.with(getContext())
				.load(Uri.parse(String.format("file:///android_asset/gallery/%s", image.getImage())))
				.into(imageView);

		clickRootView.setTranslationX(rect.left);
		clickRootView.setTranslationY(rect.top);
		clickRootView.setVisibility(View.VISIBLE);

		clickRootView.setAlpha(0);
		clickRootView.setScaleX(0);
		clickRootView.setScaleY(0);

		ViewCompat.animate(clickRootView)
				.scaleX(1)
				.scaleY(1)
				.alpha(1)
				.translationX(0)
				.translationY(0)
				.start();

		ViewCompat.animate(clickBackgroundRelativeLayout)
				.alpha(1)
				.start();
	}

	@Override
	public void hidePreview() {
		ViewCompat.animate(clickRootView)
				.scaleX(0)
				.scaleY(0)
				.alpha(0)
				.translationX(0)
				.translationY(0)
				.start();

		ViewCompat.animate(clickBackgroundRelativeLayout)
				.alpha(0)
				.start();
	}

	@Override
	public void back() {
		backPress = true;
		getActivity().onBackPressed();
		backPress = false;
	}

	@Override
	public boolean onBackPressed() {
		if (!backPress) {
			galleryPresenter.userClickBack();
		}
		return !backPress;
	}
}

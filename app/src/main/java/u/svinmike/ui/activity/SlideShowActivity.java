package u.svinmike.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;
import com.f2prateek.dart.InjectExtra;

import java.util.List;

import butterknife.BindView;
import u.svinmike.R;
import u.svinmike.mvp.model.data.Image;
import u.svinmike.mvp.presenter.SlideShowPresenter;
import u.svinmike.mvp.view.SlideShowView;
import u.svinmike.ui.adapter.BaseViewPagerAdapter;
import u.svinmike.ui.view.ZoomOutPageTransformer;

/**
 * Date: 02.02.2017
 * Time: 23:48
 *
 * @author Savin Mikhail
 */
public class SlideShowActivity extends BaseActivity implements SlideShowView {
	private static final String TAG = "SlideShowActivity";
	public static final String KEY_POSITION = TAG + "KEY_POSITION";

	public static void startActivity(Context context, int position) {
		Intent intent = new Intent(context, SlideShowActivity.class);
		intent.putExtra(KEY_POSITION, position);
		context.startActivity(intent);
	}

	@InjectExtra(KEY_POSITION)
	Integer position;

	@BindView(R.id.activity_slide_show_viewPager)
	ViewPager viewPager;

	@InjectPresenter
	SlideShowPresenter galleryPresenter;
	ImagePagerAdapter adapter;


	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slide_show);

		adapter = new ImagePagerAdapter(getContext());
		viewPager.setAdapter(adapter);
		viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

		viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(final int position) {
				super.onPageSelected(position);
				galleryPresenter.startTimer();
			}
		});
	}

	@Override
	public void showTotalProgress() {

	}

	@Override
	public void showImages(final List<Image> images) {
		adapter.setCollections(images);
		viewPager.setCurrentItem(position);
	}

	@Override
	public void hideTotalProgress() {

	}

	@Override
	public void slideToNext() {
		if (viewPager.getCurrentItem() == adapter.getCount() - 1) {
			viewPager.setCurrentItem(0, false);
		} else {
			viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
		}
	}

	private static class ImagePagerAdapter extends BaseViewPagerAdapter<Image> {

		public ImagePagerAdapter(final Context context) {
			super(context);
		}

		@Override
		protected View bindView(final ViewGroup collection, final int position) {
			final ImageView imageView = new ImageView(getContext());
			imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
			imageView.setAdjustViewBounds(true);
			Glide.with(imageView.getContext())
					.load(Uri.parse(String.format("file:///android_asset/gallery/%s", getItem(position).getImage())))
					.into(imageView);
			return imageView;
		}

		@Override
		protected void addView(final ViewGroup container, final View view) {
			container.addView(view, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);
		}
	}
}

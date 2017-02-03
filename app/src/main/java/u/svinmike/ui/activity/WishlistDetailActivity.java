package u.svinmike.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.arellomobile.plugins.BackPressedToolbarPlugin;
import com.arellomobile.plugins.base.CompositionPlugin;
import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;

import butterknife.BindView;
import butterknife.ButterKnife;
import u.svinmike.R;
import u.svinmike.di.DependencyManager;
import u.svinmike.mvp.model.data.WishList;
import u.svinmike.mvp.presenter.WishlistDetailPresenter;
import u.svinmike.mvp.view.WishListDetailView;

/**
 * Date: 01.02.2017
 * Time: 20:19
 *
 * @author Savin Mikhail
 */
public class WishlistDetailActivity extends BaseActivity implements WishListDetailView {
	private static final String TAG = "WishlistDetailActivity";
	public static final String KEY_WISHLIST_ID = TAG + "KEY_WISHLIST_ID";
	private BackPressedToolbarPlugin plugin;

	public static void startActivity(Context context, WishList wishList) {
		Intent intent = new Intent(context, WishlistDetailActivity.class);
		intent.putExtra(KEY_WISHLIST_ID, wishList.getId());
		context.startActivity(intent);
	}

	@BindView(R.id.activity_wishlist_description_checkImageView)
	ImageView checkImageView;
	@BindView(R.id.activity_wishlist_description_imageView)
	ImageView imageView;
	@BindView(R.id.activity_wishlist_description_candleLinearLayout)
	LinearLayout candleLinearLayout;
	@BindView(R.id.activity_wishlist_description_priceTextView)
	TextView priceTextView;
	@BindView(R.id.activity_wishlist_description_descriptionTextView)
	TextView descriptionTextView;
	@BindView(R.id.activity_wishlist_description_activateButton)
	Button activateButton;

	@InjectExtra
	Integer id;

	@InjectPresenter
	WishlistDetailPresenter wishlistPresenter;

	@ProvidePresenter
	WishlistDetailPresenter provideWishlistDetailPresenter() {
		Dart.inject(this);
		return new WishlistDetailPresenter(id);
	}

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wishlist_description);
		ButterKnife.bind(this);
	}

	@Override
	public void showWishList(final WishList wishList) {
		imageView.setImageResource(wishList.getImage());
		if (wishList.getCount() == wishList.getActiveCount()) {
			checkImageView.setVisibility(View.VISIBLE);
			activateButton.setEnabled(false);
		} else {
			checkImageView.setVisibility(View.INVISIBLE);
			activateButton.setEnabled(true);
		}

		candleLinearLayout.removeAllViews();
		if (wishList.getCount() > 1) {
			for (int i = 0; i < wishList.getCount(); i++) {
				ImageView imageView = new ImageView(this);
				imageView.setImageResource(R.drawable.ic_candle);
				imageView.setSelected(i < wishList.getActiveCount());
				candleLinearLayout.addView(imageView);
			}
		}

		if(wishList.getPrice() == null){
			priceTextView.setVisibility(View.GONE);
		} else {
			priceTextView.setVisibility(View.VISIBLE);
			priceTextView.setText(String.format("Допустимый лимит: %s руб.", DependencyManager.getAppComponent().decimalFormatter().format(wishList.getPrice())));
		}

		descriptionTextView.setText(wishList.getDescription());

		plugin.setTitle(wishList.getTitle());
	}

	@Override
	protected void initPlugins(final CompositionPlugin compositionPlugin) {
		super.initPlugins(compositionPlugin);
		plugin = new BackPressedToolbarPlugin(this);
		compositionPlugin.attach(plugin);
	}

	@Override
	public void startLoadingWishList() {

	}

	@Override
	public void finishLoadingWishList() {

	}
}

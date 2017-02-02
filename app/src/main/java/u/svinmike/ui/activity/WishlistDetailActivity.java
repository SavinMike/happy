package u.svinmike.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.f2prateek.dart.InjectExtra;

import u.svinmike.mvp.model.data.WishList;

/**
 * Date: 01.02.2017
 * Time: 20:19
 *
 * @author Savin Mikhail
 */
public class WishlistDetailActivity extends BaseActivity {
	private static final String TAG = "WishlistDetailActivity";
	public static final String KEY_WISHLIST_ID = TAG + "KEY_WISHLIST_ID";

	public static void startActivity(Context context, WishList wishList){
		Intent intent = new Intent(context, WishlistDetailActivity.class);
		intent.putExtra(KEY_WISHLIST_ID, wishList.getId());
		context.startActivity(intent);
	}


	@InjectExtra
	Integer id;

}

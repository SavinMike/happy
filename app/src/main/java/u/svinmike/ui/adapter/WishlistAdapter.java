package u.svinmike.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import u.svinmike.R;
import u.svinmike.mvp.model.data.WishList;

/**
 * Date: 01.02.2017
 * Time: 19:44
 *
 * @author Savin Mikhail
 */
public class WishlistAdapter extends BaseRecyclerAdapter<WishlistAdapter.ViewHolder, WishList> {

	public WishlistAdapter(final Context context) {
		super(context);
	}

	@Override
	public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
		return new ViewHolder(parent, this);
	}

	public static class ViewHolder extends BaseRecyclerAdapter.ViewHolder<WishList> {

		@BindView(R.id.item_wishlist_itemImageView)
		ImageView itemImageView;
		@BindView(R.id.item_wishlist_doneImageView)
		ImageView doneImageView;
		@BindView(R.id.item_wishlist_titleTextView)
		TextView titleTextView;
		@BindView(R.id.item_wishlist_counterTextView)
		TextView counterTextView;

		public ViewHolder(final ViewGroup parentView, final BaseRecyclerAdapter<?, ?> tHomeToursAdapter) {
			super(R.layout.item_wishlist, parentView, tHomeToursAdapter);
		}

		@Override
		public void fillView(final WishList wishList, final int position) {
			itemImageView.setImageResource(wishList.getImage());
			doneImageView.setVisibility(wishList.getActiveCount() == wishList.getCount() ? View.VISIBLE : View.INVISIBLE);
			titleTextView.setText(wishList.getTitle());

			counterTextView.setVisibility(wishList.getActiveCount() == wishList.getCount() ? View.GONE : View.VISIBLE);
			counterTextView.setText(String.format("%s/%s", wishList.getActiveCount(), wishList.getCount()));
		}
	}
}

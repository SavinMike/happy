package u.svinmike.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

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

		public ViewHolder(final ViewGroup parentView, final BaseRecyclerAdapter<?, ?> tHomeToursAdapter) {
			super(R.layout.item_wishlist, parentView, tHomeToursAdapter);
		}

		@Override
		public void fillView(final WishList wishList, final int position) {

		}
	}
}

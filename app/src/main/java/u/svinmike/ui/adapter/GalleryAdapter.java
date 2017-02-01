package u.svinmike.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import u.svinmike.R;
import u.svinmike.mvp.model.data.Image;

/**
 * Date: 01.02.2017
 * Time: 19:44
 *
 * @author Savin Mikhail
 */
public class GalleryAdapter extends BaseRecyclerAdapter<GalleryAdapter.ViewHolder, Image> {

	public GalleryAdapter(final Context context) {
		super(context);
	}

	@Override
	public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
		return new ViewHolder(parent, this);
	}

	@Override
	public int getItemCount() {
		return 100;
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, final int position) {

	}

	public static class ViewHolder extends BaseRecyclerAdapter.ViewHolder<Image> {

		public ViewHolder(final ViewGroup parentView, final BaseRecyclerAdapter<?, ?> tHomeToursAdapter) {
			super(R.layout.item_gallery, parentView, tHomeToursAdapter);
		}

		@Override
		public void fillView(final Image wishList, final int position) {

		}
	}
}

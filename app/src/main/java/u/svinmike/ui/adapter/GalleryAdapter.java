package u.svinmike.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
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

	public static class ViewHolder extends BaseRecyclerAdapter.ViewHolder<Image> {

		@BindView(R.id.item_gallery_itemImageView)
		ImageView itemImageView;
		@BindView(R.id.item_gallery_titleTextView)
		TextView titleTextView;

		public ViewHolder(final ViewGroup parentView, final BaseRecyclerAdapter<?, ?> tHomeToursAdapter) {
			super(R.layout.item_gallery, parentView, tHomeToursAdapter);
		}

		@Override
		public void fillView(final Image wishList, final int position) {
			Glide.with(itemView.getContext())
					.load(Uri.parse(String.format("file:///android_asset/gallery/%s", wishList.getImage())))
					.into(itemImageView);

			titleTextView.setText(wishList.getTitle());
		}
	}
}

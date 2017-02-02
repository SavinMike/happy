package u.svinmike.ui.adapter.gallery;

import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import u.svinmike.R;
import u.svinmike.mvp.model.data.Image;
import u.svinmike.ui.adapter.BaseRecyclerAdapter;

public class ImageViewHolder extends BaseRecyclerAdapter.ViewHolder<ImageWrapper> {


	@BindView(R.id.item_gallery_leftImageView)
	ImageView leftImageView;
	@BindView(R.id.item_gallery_leftTitleTextView)
	TextView leftTitleTextView;
	@BindView(R.id.item_gallery_rightImageView)
	ImageView rightImageView;
	@BindView(R.id.item_gallery_rightTitleTextView)
	TextView rightTitleTextView;
	@BindView(R.id.item_gallery_rightRelativeLayout)
	RelativeLayout rightRelativeLayout;

	GalleryAdapter galleryAdapter;

	public ImageViewHolder(final ViewGroup parentView, final GalleryAdapter galleryAdapter) {
		super(R.layout.item_gallery, parentView, galleryAdapter);
		this.galleryAdapter = galleryAdapter;
	}

	@Override
	public void fillView(final ImageWrapper wrapper, final int position) {
		setView(wrapper.getLeft(), leftImageView, leftTitleTextView, position);

		if (wrapper.getRight() == null) {
			rightRelativeLayout.setVisibility(View.INVISIBLE);
		} else {
			rightRelativeLayout.setVisibility(View.VISIBLE);
			setView(wrapper.getRight(), rightImageView, rightTitleTextView, position);
		}
	}

	private void setView(final Image left, final ImageView leftImageView, final TextView leftTitleTextView, final int position) {
		Glide.with(itemView.getContext())
				.load(Uri.parse(String.format("file:///android_asset/gallery/%s", left.getImage())))
				.into(leftImageView);

		leftImageView.setTag(R.id.image_model, left);
		leftImageView.setTag(R.id.position, position);

		leftTitleTextView.setText(left.getTitle());
	}

	@Override
	protected void initListeners() {
		leftImageView.setOnClickListener(v -> {
			View parent = (View) v.getParent();
			galleryAdapter.onImageClick((Image) v.getTag(R.id.image_model), new Rect(parent.getLeft() + parent.getPaddingLeft() + itemView.getLeft(), parent.getTop() + parent.getPaddingTop() + itemView.getTop(), parent.getRight() + parent.getPaddingRight(), itemView.getBottom() - itemView.getPaddingBottom()), (Integer) v.getTag(R.id.position));
		});
		rightImageView.setOnClickListener(v -> {
			View parent = (View) v.getParent();
			galleryAdapter.onImageClick((Image) v.getTag(R.id.image_model), new Rect(parent.getLeft() + parent.getPaddingLeft() + itemView.getLeft(), parent.getTop() + parent.getPaddingTop() + itemView.getTop(), parent.getRight() + parent.getPaddingRight(), itemView.getBottom() - itemView.getPaddingBottom()), (Integer) v.getTag(R.id.position));
		});
	}
}
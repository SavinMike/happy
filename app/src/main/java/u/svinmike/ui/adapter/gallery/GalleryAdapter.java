package u.svinmike.ui.adapter.gallery;

import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import u.svinmike.mvp.model.data.Image;
import u.svinmike.ui.adapter.BaseRecyclerAdapter;

/**
 * Date: 01.02.2017
 * Time: 19:44
 *
 * @author Savin Mikhail
 */
public class GalleryAdapter extends BaseRecyclerAdapter<BaseRecyclerAdapter.ViewHolder<ImageWrapper>, ImageWrapper> {
	public static final int CATEGORY_TYPE = 0;
	public static final int IMAGE_TYPE = 1;

	private OnImageClick onImageClick;
	private List<Image> images = new ArrayList<>();

	public GalleryAdapter(final Context context) {
		super(context);
	}

	@Override
	public BaseRecyclerAdapter.ViewHolder<ImageWrapper> onCreateViewHolder(final ViewGroup parent, final int viewType) {
		switch (viewType) {
			case IMAGE_TYPE:
				return new ImageViewHolder(parent, this);
			case CATEGORY_TYPE:
				return new CategoryViewHolder(parent, this);
		}

		return null;
	}

	public void setCollection(List<Image> images) {
		this.images.clear();
		this.images.addAll(images);
		List<ImageWrapper> result = new ArrayList<>();
		String category = null;
		Image left = null;
		Image right = null;

		for (Image image : images) {
			if (!image.getCategory().equals(category)) {
				if (left != null) {
					result.add(new ImageWrapper(left, right));
					left = null;
					right = null;
				}

				category = image.getCategory();
				result.add(new ImageWrapper(category));
			}

			if (left == null) {
				left = image;
			} else {
				right = image;

				result.add(new ImageWrapper(left, right));
				left = null;
				right = null;
			}
		}

		setCollection(result);
	}

	@Override
	public long getItemId(final int position) {
		return position;
	}

	protected void onImageClick(Image image, Rect rect, final int adapterPosition) {
		if (onImageClick != null) {
			onImageClick.onImageClick(image, rect, images.indexOf(image));
		}
	}

	@Override
	public int getItemViewType(final int position) {
		return getItem(position).getCategory() != null ? CATEGORY_TYPE : IMAGE_TYPE;
	}

	public void setOnImageClick(final OnImageClick onImageClick) {
		this.onImageClick = onImageClick;
	}

	public interface OnImageClick {
		void onImageClick(Image image, Rect rect, int position);
	}
}

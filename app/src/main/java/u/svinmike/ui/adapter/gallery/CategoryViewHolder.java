package u.svinmike.ui.adapter.gallery;

import android.view.ViewGroup;
import android.widget.TextView;

import u.svinmike.R;
import u.svinmike.ui.adapter.BaseRecyclerAdapter;

/**
 * Date: 02.02.2017
 * Time: 21:10
 *
 * @author Savin Mikhail
 */
public class CategoryViewHolder extends BaseRecyclerAdapter.ViewHolder<ImageWrapper> {
	public CategoryViewHolder(final ViewGroup parent, final GalleryAdapter galleryAdapter) {
		super(R.layout.item_category, parent, galleryAdapter);
	}

	@Override
	public void fillView(final ImageWrapper imageWrapper, final int position) {
		((TextView) itemView).setText(imageWrapper.getCategory());
	}

	@Override
	protected void initListeners() {

	}
}

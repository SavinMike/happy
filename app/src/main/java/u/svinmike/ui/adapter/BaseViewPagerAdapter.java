package u.svinmike.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import u.svinmike.R;

/**
 * Date: 28.08.2015
 * Time: 14:55
 *
 * @author Savin Mikhail
 */
public abstract class BaseViewPagerAdapter<T> extends PagerAdapter {
	private List<T> mList = new ArrayList<>();
	private Context mContext;
	private LayoutInflater mLayoutInflater;
	private OnItemClickListener mOnItemClickListener;

	public BaseViewPagerAdapter(final Context context) {
		mContext = context;
		mLayoutInflater = LayoutInflater.from(context);
	}


	public void setCollections(Collection<T> imagesList) {
		mList.clear();
		mList.addAll(imagesList);
		notifyDataSetChanged();
	}

	public T getItem(int position) {
		return mList.get(position);
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	public Context getContext() {
		return mContext;
	}

	protected Collection<T> getCollection() {
		return mList;
	}

	public LayoutInflater getLayoutInflater() {
		return mLayoutInflater;
	}

	@Override
	public void destroyItem(ViewGroup collection, int position, Object view) {
		collection.removeView((View) view);
	}

	@Override
	public final View instantiateItem(ViewGroup collection, int position) {
		View view = bindView(collection, position);
		view.setTag(R.id.position, position);
		if (position >= getCount()) {
			return view;
		}
		view.setTag(R.id.model, getItem(position));
		view.setOnClickListener(v -> {
			if (mOnItemClickListener != null) {
				mOnItemClickListener.onItemClick((Integer) v.getTag(R.id.position));
			}
		});
		addView(collection, view);
		return view;
	}

	protected void addView(final ViewGroup container, final View view) {
		container.addView(view);
	}

	protected abstract View bindView(final ViewGroup collection, final int position);


	//http://developer.android.com/reference/android/support/v4/view/PagerAdapter.html
	@Override
	public boolean isViewFromObject(final View view, final Object o) {
		return view == o;
	}

	public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
		mOnItemClickListener = onItemClickListener;
	}

	@Override
	public int getItemPosition(final Object object) {
		if (object instanceof View) {
			Object tag = ((View) object).getTag(R.id.model);
			Integer position = (Integer) ((View) object).getTag(R.id.position);
			if (tag == null || getCount() <= position || !tag.equals(getItem(position))) {
				return POSITION_NONE;
			}
		}
		return super.getItemPosition(object);
	}

	public interface OnItemClickListener {
		void onItemClick(int position);
	}
}

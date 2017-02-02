package u.svinmike.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.ButterKnife;

public abstract class BaseRecyclerAdapter<VH extends BaseRecyclerAdapter.ViewHolder, Model> extends RecyclerView.Adapter<VH> {
	private List<Model> mDataList = new ArrayList<>();

	protected OnItemClickListener mOnItemClickListener;
	private Context mContext;

	public BaseRecyclerAdapter(final Context context) {
		mContext = context;
	}

	public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
		mOnItemClickListener = onItemClickListener;
		notifyDataSetChanged();
	}

	@Override
	public void onBindViewHolder(final VH holder, final int position) {
		Model item = getItem(position);
		//noinspection unchecked
		holder.fillView(item, position);
	}

	@Override
	public int getItemCount() {
		return mDataList.size();
	}

	public void setCollection(Collection<? extends Model> list) {
		mDataList.clear();
		if (list != null) {
			mDataList.addAll(list);
		}
		notifyDataSetChanged();
	}

	public void addCollection(Collection<? extends Model> list) {
		if (list != null) {
			mDataList.addAll(list);
		}
		notifyDataSetChanged();
	}

	public List<Model> getCollections() {
		return mDataList;
	}

	public Model getItem(int position) {
		return mDataList.get(position);
	}

	public void clearCollection() {
		mDataList.clear();
		notifyDataSetChanged();
	}

	public interface OnItemClickListener {
		void onItemClick(View view, int position);
	}

	public abstract static class ViewHolder<Model> extends RecyclerView.ViewHolder implements View.OnClickListener {
		// each data item is just a string in this case
		public final BaseRecyclerAdapter<?, ?> mAdapter;
		public final View mRootView;

		public ViewHolder(int layoutId, ViewGroup parentView, final BaseRecyclerAdapter<?, ?> tHomeToursAdapter) {
			this(LayoutInflater.from(parentView.getContext()).inflate(layoutId, parentView, false), tHomeToursAdapter);
		}

		protected ViewHolder(View view, final BaseRecyclerAdapter<?, ?> tHomeToursAdapter) {
			super(view);
			mRootView = itemView;
			mAdapter = tHomeToursAdapter;
			ButterKnife.bind(this, mRootView);
			initListeners();
		}

		protected void initListeners() {
			mRootView.setOnClickListener(this);
		}

		public abstract void fillView(Model model, int position);

		protected Context getContext() {
			return mAdapter.getContext();
		}

		@Override
		public void onClick(final View v) {
			if (mAdapter.mOnItemClickListener != null) {
				mAdapter.mOnItemClickListener.onItemClick(v, getAdapterPosition());
			}
		}
	}

	public Context getContext() {
		return mContext;
	}
}
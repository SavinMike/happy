package u.svinmike.ui.adapter.statistic;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import u.svinmike.R;
import u.svinmike.di.DependencyManager;
import u.svinmike.mvp.model.data.Statistic;
import u.svinmike.mvp.model.formatter.DecimalFormatter;
import u.svinmike.ui.adapter.BaseRecyclerAdapter;

/**
 * Date: 03.02.2017
 * Time: 23:15
 *
 * @author Savin Mikhail
 */
public class StatisticAdapter extends BaseRecyclerAdapter<StatisticAdapter.ViewHolder, Statistic> {

	private final Disposable subscribe;

	public StatisticAdapter(final Context context) {
		super(context);

		subscribe = Observable.interval(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(aLong -> {
					notifyDataSetChanged();
				});
	}

	public void close() {
		subscribe.dispose();
	}

	@Override
	public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
		return new ViewHolder(parent, this);
	}

	public static class ViewHolder extends BaseRecyclerAdapter.ViewHolder<Statistic> {

		@BindView(R.id.item_statistic_titleTextView)
		TextView titleTextView;
		@BindView(R.id.item_statistic_secTextView)
		TextView secTextView;
		@BindView(R.id.item_statistic_hoursTextView)
		TextView hoursTextView;
		@BindView(R.id.item_statistic_dateTextView)
		TextView dateTextView;

		public ViewHolder(final ViewGroup parentView, final BaseRecyclerAdapter<?, ?> tHomeToursAdapter) {
			super(R.layout.item_statistic, parentView, tHomeToursAdapter);
		}

		@Override
		public void fillView(final Statistic statistic, final int position) {
			titleTextView.setText(statistic.getName());

			Calendar calendar = Calendar.getInstance();

			long l = System.currentTimeMillis() - statistic.getDate().getTime();
			calendar.setTimeInMillis(l);
			int years = calendar.get(Calendar.YEAR) - 1970;
			dateTextView.setText(years + " " + (years == 1 ? "год" : years < 5 ? "года" : "лет") + " " + (calendar.get(Calendar.MONTH)) + " м");

			DecimalFormatter decimalFormatter = DependencyManager.getAppComponent().integerDecimalFormatter();
			hoursTextView.setText(String.format("%s ч", decimalFormatter.format(TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis() - statistic.getDate().getTime()))));
			secTextView.setText(String.format("%s сек", decimalFormatter.format(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - statistic.getDate().getTime()))));
		}
	}
}

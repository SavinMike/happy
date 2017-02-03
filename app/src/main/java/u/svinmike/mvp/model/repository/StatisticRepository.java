package u.svinmike.mvp.model.repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import u.svinmike.mvp.model.data.Statistic;
import u.svinmike.mvp.model.formatter.StringDateFormatter;

/**
 * Date: 03.02.2017
 * Time: 22:57
 *
 * @author Savin Mikhail
 */
public class StatisticRepository {

	StringDateFormatter stringDateFormatter;

	public StatisticRepository(final StringDateFormatter dateFormatter) {
		stringDateFormatter = dateFormatter;
	}

	public Single<List<Statistic>> provideStatistic() {
		return Single.create(e -> {
			List<Statistic> statistic = new ArrayList<>();

			statistic.add(Statistic.builder()
					.name("Времени с первой встречи")
					.date(stringDateFormatter.format("01.03.2008"))
					.build());
			statistic.add(Statistic.builder()
					.name("Времени со свадьбы")
					.date(stringDateFormatter.format("31.07.2009"))
					.build());
			statistic.add(Statistic.builder()
					.name("Возраст Степы")
					.date(stringDateFormatter.format("06.05.2012"))
					.build());
			statistic.add(Statistic.builder()
					.name("Возраст Ксюни")
					.date(stringDateFormatter.format("22.11.2013"))
					.build());

			e.onSuccess(statistic);
		});
	}
}

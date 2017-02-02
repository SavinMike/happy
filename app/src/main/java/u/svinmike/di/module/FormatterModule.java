package u.svinmike.di.module;

import java.text.SimpleDateFormat;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import u.svinmike.mvp.model.formatter.DateStringFormatter;
import u.svinmike.mvp.model.formatter.DecimalFormatter;
import u.svinmike.mvp.model.formatter.StringDateFormatter;

/**
 * Date: 05.12.2016
 * Time: 12:35
 *
 * @author Savin Mikhail
 */
@Module
public class FormatterModule {
	private static final String TAG = "FormatterModule";
	public static final String KEY_DATE = TAG + "KEY_DATE";

	public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

	@Provides
	@Named(KEY_DATE)
	public DateStringFormatter provideDateFormatter() {
		return new DateStringFormatter(DATE_FORMAT);
	}

	@Provides
	@Named(KEY_DATE)
	public StringDateFormatter provideStringTimeFormatter() {
		return new StringDateFormatter(DATE_FORMAT);
	}

	@Provides
	public DecimalFormatter provideDecimalFormatter() {
		return new DecimalFormatter();
	}
}

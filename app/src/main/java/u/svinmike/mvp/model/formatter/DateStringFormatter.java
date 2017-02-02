package u.svinmike.mvp.model.formatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date: 05.12.2016
 * Time: 12:33
 *
 * @author Savin Mikhail
 */
public class DateStringFormatter implements Formatter<Date, String>{
	SimpleDateFormat simpleDateFormat;

	public DateStringFormatter(final SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}

	@Override
	public String format(final Date date) {
		return simpleDateFormat.format(date);
	}
}

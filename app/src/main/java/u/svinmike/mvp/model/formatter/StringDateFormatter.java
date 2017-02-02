package u.svinmike.mvp.model.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date: 05.12.2016
 * Time: 12:33
 *
 * @author Savin Mikhail
 */
public class StringDateFormatter implements Formatter<String, Date> {
	SimpleDateFormat simpleDateFormat;

	public StringDateFormatter(final SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}

	@Override
	public Date format(final String date) {
		try {
			return simpleDateFormat.parse(date);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
}

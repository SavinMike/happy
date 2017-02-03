package u.svinmike.mvp.model.formatter;

import java.text.DecimalFormat;


/**
 * Date: 05.12.2016
 * Time: 12:26
 *
 * @author Savin Mikhail
 */
public class DecimalFormatter implements Formatter<Number, String> {

	private DecimalFormat decimalFormat;

	public DecimalFormatter(final DecimalFormat decimalFormat) {
		this.decimalFormat = decimalFormat;
	}

	@Override
	public String format(final Number number) {
		return decimalFormat.format(number);
	}


}

package u.svinmike.mvp.model.formatter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


/**
 * Date: 05.12.2016
 * Time: 12:26
 *
 * @author Savin Mikhail
 */
public class DecimalFormatter implements Formatter<Number, String> {

	private static final String ZERO = "0,00";

	private static DecimalFormat sAlwaysSignedDecimalFormat;
	private static DecimalFormat sUsualDecimalFormat;

	static {
		sAlwaysSignedDecimalFormat = new DecimalFormat("+ #,##0.00;- #");
		sUsualDecimalFormat = new DecimalFormat("#,##0.00");
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(',');
		symbols.setGroupingSeparator(' ');

		sAlwaysSignedDecimalFormat.setDecimalFormatSymbols(symbols);
		sUsualDecimalFormat.setDecimalFormatSymbols(symbols);
	}

	@Override
	public String format(final Number number) {
		return sUsualDecimalFormat.format(number);
	}


}

package u.svinmike.mvp.model.formatter.params;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecimalFormatterParams {

	public static DecimalFormatterParams get(double number) {
		return get(number, false);
	}

	public static DecimalFormatterParams get(double number, boolean alwaysSigned) {
		return new DecimalFormatterParams(number, alwaysSigned);
	}

	double number;
	boolean alwaysSigned;

	protected DecimalFormatterParams(final double number, final boolean alwaysSigned) {
		this.number = number;
		this.alwaysSigned = alwaysSigned;
	}
}
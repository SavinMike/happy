package u.svinmike.mvp.model.formatter;

/**
 * Date: 05.12.2016
 * Time: 12:23
 *
 * @author Savin Mikhail
 */
public interface Formatter<Params, Result> {
	Result format(Params params);
}

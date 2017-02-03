package u.svinmike.mvp.model.data;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

/**
 * Date: 03.02.2017
 * Time: 23:16
 *
 * @author Savin Mikhail
 */
@Builder
@Getter
public class Statistic {

	private String name;
	private Date date;
}

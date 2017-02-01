package u.svinmike.mvp.model.data;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Date: 01.02.2017
 * Time: 19:47
 *
 * @author Savin Mikhail
 */
@Builder
@Getter
@Setter
public class Image {
	private int resId;
	private String title;
	private Date date;
	private String description;
}

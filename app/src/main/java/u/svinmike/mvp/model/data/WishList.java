package u.svinmike.mvp.model.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Date: 01.02.2017
 * Time: 19:46
 *
 * @author Savin Mikhail
 */
@Builder
@Getter
@Setter
public class WishList {
	private int image;
	private boolean done;
	private boolean active;
	private String title;
	private String description;
	private Float price;
}

package u.svinmike.mvp.model.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

/**
 * Date: 01.02.2017
 * Time: 19:46
 *
 * @author Savin Mikhail
 */
@Builder
@Getter
@Setter
public class WishList extends RealmObject {
	public static final String ID = "id";
	@PrimaryKey
	private int id;
	private int image;
	private String title;
	private String description;
	private Float price;
	private int count;
	private int activeCount;

	@Tolerate
	public WishList () {/*do nothing*/}
}

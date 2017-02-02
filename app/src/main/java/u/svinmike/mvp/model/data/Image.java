package u.svinmike.mvp.model.data;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

/**
 * Date: 01.02.2017
 * Time: 19:47
 *
 * @author Savin Mikhail
 */
@Builder
@Getter
@Setter
public class Image extends RealmObject implements Comparable<Image> {
	public static final String ID = "image";
	@PrimaryKey
	private String image;
	private String title;
	private Date date;
	private String description;
	private String category;
	private boolean thumb;

	@Tolerate
	public Image() {/*do nothing*/}

	@Override
	public int compareTo(final Image o) {
		int i = date.compareTo(o.date);
		if (i == 0) {
			i = category.compareTo(o.category);
			if (i == 0) {
				i = title.compareTo(o.title);

				if (i == 0) {
					i = Boolean.valueOf(thumb).compareTo(o.thumb);
				}
			}
		}
		return i;
	}
}

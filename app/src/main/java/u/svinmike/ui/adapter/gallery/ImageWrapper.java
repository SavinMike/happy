package u.svinmike.ui.adapter.gallery;

import lombok.Getter;
import u.svinmike.mvp.model.data.Image;

/**
 * Date: 02.02.2017
 * Time: 21:07
 *
 * @author Savin Mikhail
 */
@Getter
public class ImageWrapper {
	private String category;
	private Image left;
	private Image right;

	public ImageWrapper() {/*do nothing*/}

	public ImageWrapper(final String category) {
		this.category = category;
	}

	public ImageWrapper(final Image left, final Image right) {
		this.left = left;
		this.right = right;
	}
}

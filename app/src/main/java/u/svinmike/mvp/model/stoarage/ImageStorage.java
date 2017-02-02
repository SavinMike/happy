package u.svinmike.mvp.model.stoarage;

import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import u.svinmike.mvp.model.data.Image;

/**
 * Date: 02.02.2017
 * Time: 11:07
 *
 * @author Savin Mikhail
 */
public class ImageStorage extends BaseStorage<Image, String> {

	public ImageStorage(final RealmConfiguration realmConfiguration) {
		super(Image.class, realmConfiguration);
	}

	@Override
	protected Image byId(final RealmQuery<Image> where, final String id) {
		return where.equalTo(Image.ID, id).findFirst();
	}
}

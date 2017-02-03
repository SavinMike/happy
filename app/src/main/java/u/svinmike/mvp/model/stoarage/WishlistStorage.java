package u.svinmike.mvp.model.stoarage;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import u.svinmike.mvp.model.data.WishList;

/**
 * Date: 02.02.2017
 * Time: 11:07
 *
 * @author Savin Mikhail
 */
public class WishlistStorage extends BaseStorage<WishList, Integer> {

	public WishlistStorage(final RealmConfiguration realmConfiguration) {
		super(WishList.class, realmConfiguration);
	}

	@Override
	protected WishList byId(final RealmQuery<WishList> where, final Integer id) {
		return where.equalTo(WishList.ID, id).findFirst();
	}
}

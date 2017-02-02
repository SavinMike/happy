package u.svinmike.mvp.model.stoarage;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Date: 10.01.2017
 * Time: 9:17
 *
 * @author Savin Mikhail
 */
public abstract class BaseStorage<T extends RealmModel, I> {
	Class<T> tClass;
	RealmConfiguration realmConfiguration;

	public BaseStorage(Class<T> tClass, final RealmConfiguration realmConfiguration) {
		this.realmConfiguration = realmConfiguration;
		this.tClass = tClass;
	}

	public void recreateTable(List<T> models) {
		Realm realm = realm();
		realm.executeTransaction(realm1 -> {
			realm1.delete(tClass);
			realm1.copyToRealmOrUpdate(models);
		});
		realm.close();
	}

	public Maybe<T> getById(I id) {
		return Maybe.create(subscriber -> {
			Realm realm = realm();
			T result = byId(realm.where(tClass), id);
			if (result != null) {
				subscriber.onSuccess(realm.copyFromRealm(result));
				realm.close();
			}
			subscriber.onComplete();
		});
	}

	protected abstract T byId(final RealmQuery<T> where, final I id);

	public Single<List<T>> getAll() {
		return Single.create(subscriber -> {
			Realm realm = realm();
			RealmResults<T> all = realm.where(tClass).findAll();
			subscriber.onSuccess(realm.copyFromRealm(all));
			realm.close();
		});
	}


	public void saveModels(final List<T> models) {
		Realm realm = realm();
		realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(models));
		realm.close();
	}

	private Realm realm() {
		return Realm.getInstance(realmConfiguration);
	}

	public void clear() {
		realm().delete(tClass);
	}

	public void saveModel(final T model) {
		Realm realm = realm();
		realm.executeTransaction(realm1 -> {
			realm1.copyToRealmOrUpdate(model);
		});
		realm.close();
	}
}

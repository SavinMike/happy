package u.svinmike.app;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import u.svinmike.di.DependencyManager;

public class RealmManager {

	RealmConfiguration realmConfiguration;
	Realm realm;

	@Inject
	public RealmManager(final RealmConfiguration realmConfiguration, boolean isDefault) {
		this.realmConfiguration = realmConfiguration;
		setup(isDefault);
	}

	private void setup(final boolean isDefault) {
		if (realmConfiguration != null) {
			realm = Realm.getInstance(realmConfiguration);
			if (isDefault) {
				Realm.setDefaultConfiguration(realmConfiguration);
			}
		} else {
			throw new IllegalStateException("database already configured");
		}
	}

	public Realm realm() {
		return realm;
	}

	public void close() {
		realm().close();
	}

	public static Realm getDefaultInstance() {
		return DependencyManager.getAppComponent().defaultRealmManager().realm();
	}
} 
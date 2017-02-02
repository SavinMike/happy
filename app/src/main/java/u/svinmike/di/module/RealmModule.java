package u.svinmike.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.RealmConfiguration;
import u.svinmike.app.RealmManager;

/**
 * Date: 10.01.2017
 * Time: 11:01
 *
 * @author Savin Mikhail
 */
@Module
public class RealmModule {
	private static final String TAG = "RealmModule";
	private static final int VERSION = 1;
	private static final String DB_NAME = "sibeco.realm";

	public static final String KEY_DEFAULT_CONFIGURATION = TAG + "KEY_DEFAULT_CONFIGURATION";

	@Provides
	@Singleton
	@Named(KEY_DEFAULT_CONFIGURATION)
	RealmConfiguration provideRealmConfiguration() {
		return new RealmConfiguration.Builder()
				.schemaVersion(VERSION)
				.name(DB_NAME)
				.deleteRealmIfMigrationNeeded()
				.build();
	}

	@Named(KEY_DEFAULT_CONFIGURATION)
	@Provides
	@Singleton
	RealmManager provideRealmManager(@Named(KEY_DEFAULT_CONFIGURATION) RealmConfiguration realmConfiguration) {
		return new RealmManager(realmConfiguration, true);
	}
}

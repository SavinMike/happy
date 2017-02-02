package u.svinmike.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.RealmConfiguration;
import u.svinmike.mvp.model.stoarage.ImageStorage;
import u.svinmike.mvp.model.stoarage.WishlistStorage;

/**
 * Date: 28.12.2016
 * Time: 22:30
 *
 * @author Savin Mikhail
 */
@Module(includes = RealmModule.class)
public class StorageModule {

	@Provides
	@Singleton
	public WishlistStorage provideWishlistStorage(@Named(RealmModule.KEY_DEFAULT_CONFIGURATION) RealmConfiguration realmConfiguration) {
		return new WishlistStorage(realmConfiguration);
	}

	@Provides
	@Singleton
	public ImageStorage provideImageStorage(@Named(RealmModule.KEY_DEFAULT_CONFIGURATION) RealmConfiguration realmConfiguration) {
		return new ImageStorage(realmConfiguration);
	}
}

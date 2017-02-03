package u.svinmike.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import u.svinmike.mvp.model.formatter.StringDateFormatter;
import u.svinmike.mvp.model.repository.ImagesRepository;
import u.svinmike.mvp.model.repository.StatisticRepository;
import u.svinmike.mvp.model.repository.WishlistRepository;
import u.svinmike.mvp.model.stoarage.ImageStorage;
import u.svinmike.mvp.model.stoarage.WishlistStorage;

/**
 * Date: 02.02.2017
 * Time: 11:24
 *
 * @author Savin Mikhail
 */
@Module(includes = StorageModule.class)
public class RepositoryModule {
	@Provides
	@Singleton
	WishlistRepository provideWishlistRepository(WishlistStorage wishlistStorage) {
		return new WishlistRepository(wishlistStorage);
	}


	@Provides
	@Singleton
	ImagesRepository provideImagesRepository(ImageStorage imageStorage, @Named(FormatterModule.KEY_DATE) StringDateFormatter dateFormatter) {
		return new ImagesRepository(imageStorage, dateFormatter);
	}

	@Provides
	@Singleton
	StatisticRepository provideStatisticRepository(@Named(FormatterModule.KEY_DATE) StringDateFormatter dateFormatter) {
		return new StatisticRepository(dateFormatter);
	}
}

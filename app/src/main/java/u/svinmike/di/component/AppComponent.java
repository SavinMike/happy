package u.svinmike.di.component;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import u.svinmike.app.RealmManager;
import u.svinmike.di.module.ContextModule;
import u.svinmike.di.module.FormatterModule;
import u.svinmike.di.module.RealmModule;
import u.svinmike.di.module.RepositoryModule;
import u.svinmike.mvp.model.formatter.DecimalFormatter;
import u.svinmike.mvp.presenter.GalleryPresenter;
import u.svinmike.mvp.presenter.SlideShowPresenter;
import u.svinmike.mvp.presenter.WishlistDetailPresenter;
import u.svinmike.mvp.presenter.WishlistPresenter;

/**
 * Date: 02.02.2017
 * Time: 11:06
 *
 * @author Savin Mikhail
 */
@Component(modules = {ContextModule.class, RepositoryModule.class, FormatterModule.class})
@Singleton
public interface AppComponent {
	@Named(RealmModule.KEY_DEFAULT_CONFIGURATION)
	RealmManager defaultRealmManager();

	DecimalFormatter decimalFormatter();

	Context context();

	void inject(WishlistPresenter wishlistPresenter);

	void inject(GalleryPresenter galleryPresenter);

	void inject(SlideShowPresenter slideShowPresenter);

	void inject(WishlistDetailPresenter wishlistDetailPresenter);
}

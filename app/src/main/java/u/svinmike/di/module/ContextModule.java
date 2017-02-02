package u.svinmike.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Date: 28.12.2016
 * Time: 22:21
 *
 * @author Savin Mikhail
 */
@Module
public class ContextModule {

	private Context context;

	public ContextModule(final Context context) {
		this.context = context;
	}

	@Provides
	@Singleton
	public Context provideContext() {
		return context;
	}
}

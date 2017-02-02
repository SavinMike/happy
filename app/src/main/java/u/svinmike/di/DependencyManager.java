package u.svinmike.di;

import android.content.Context;

import u.svinmike.di.component.AppComponent;
import u.svinmike.di.component.DaggerAppComponent;
import u.svinmike.di.module.ContextModule;


/**
 * Date: 19.12.2016
 * Time: 13:04
 *
 * @author Savin Mikhail
 */
public class DependencyManager {
	private static volatile DependencyManager dependencyManager;

	public static DependencyManager get() {
		if (dependencyManager == null) {
			synchronized (DependencyManager.class) {
				if (dependencyManager == null) {
					dependencyManager = new DependencyManager();
				}
			}
		}

		return dependencyManager;
	}

	private AppComponent appComponent;

	private DependencyManager() {
	}

	public void initAppComponent(Context context) {
		appComponent = DaggerAppComponent.builder()
				.contextModule(new ContextModule(context))
				.build();
	}

	public static AppComponent getAppComponent() {
		return get().appComponent;
	}
}

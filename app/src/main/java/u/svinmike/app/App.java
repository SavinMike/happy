package u.svinmike.app;

import android.app.Application;

import io.realm.Realm;
import u.svinmike.di.DependencyManager;

/**
 * Date: 02.02.2017
 * Time: 11:44
 *
 * @author Savin Mikhail
 */
public class App extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		Realm.init(this);
		DependencyManager.get().initAppComponent(this);
	}
}

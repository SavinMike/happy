package u.svinmike.ui.fragment;

import android.support.v7.app.AppCompatActivity;

import com.arellomobile.plugins.ToolbarPlugin;
import com.arellomobile.plugins.base.CompositionPlugin;

/**
 * Date: 01.02.2017
 * Time: 19:39
 *
 * @author Savin Mikhail
 */
public abstract class NavigationFragment extends BaseFragment {

	@Override
	protected void initPlugins(final CompositionPlugin compositionPlugin) {
		super.initPlugins(compositionPlugin);
		ToolbarPlugin plugin = new ToolbarPlugin((AppCompatActivity) getActivity());
		plugin.setTitle(getTitle());
		compositionPlugin.attach(plugin);
	}

	protected String getTitle() {
		return null;
	}
}

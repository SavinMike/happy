package u.svinmike.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.plugins.ContextProvider;
import com.arellomobile.plugins.base.CompositionPlugin;
import com.arellomobile.plugins.base.CompositionPluginDelegate;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Date: 19.12.2016
 * Time: 12:51
 *
 * @author Savin Mikhail
 */
public abstract class BaseFragment extends MvpAppCompatFragment implements ContextProvider {
	private final CompositionPlugin compositionPlugin = new CompositionPluginDelegate();
	private Unbinder unbinder;

	protected void initPlugins(CompositionPlugin compositionPlugin) {

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initPlugins(compositionPlugin);
		compositionPlugin.onCreate();
	}

	@Nullable
	@Override
	public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), getTheme());

		// clone the inflater using the ContextThemeWrapper
		LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);

		// inflate the layout using the cloned inflater, not default inflater
		View view = localInflater.inflate(getContainerViewId(), container, false);
		unbinder = ButterKnife.bind(this, view);
		return view;
	}

	protected abstract int getTheme();

	protected abstract int getContainerViewId();

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		compositionPlugin.onViewCreated(view);
	}

	@Override
	public void onStart() {
		super.onStart();
		compositionPlugin.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
		compositionPlugin.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		compositionPlugin.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
		compositionPlugin.onStop();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		compositionPlugin.onDestroy();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if (unbinder != null) {
			unbinder.unbind();
			unbinder = null;
		}
	}


}

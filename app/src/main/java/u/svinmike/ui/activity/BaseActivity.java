package u.svinmike.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.plugins.ContextProvider;
import com.arellomobile.plugins.base.CompositionPlugin;
import com.arellomobile.plugins.base.CompositionPluginDelegate;

import butterknife.ButterKnife;


/**
 * Date: 10.10.2016
 * Time: 12:24
 *
 * @author Yuri Shmakov
 */

public abstract class BaseActivity extends MvpAppCompatActivity implements ContextProvider {

	private final CompositionPlugin compositionPlugin = new CompositionPluginDelegate();

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initPlugins(compositionPlugin);
		compositionPlugin.onCreate();
	}

	protected void initPlugins(final CompositionPlugin compositionPlugin) {

	}

	@Override
	public void setContentView(@LayoutRes int layoutResID) {
		super.setContentView(layoutResID);
		compositionPlugin.onViewCreated(getWindow().findViewById(android.R.id.content));
		ButterKnife.bind(this);
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			return onHomeButtonPressed();
		}
		return super.onOptionsItemSelected(item);
	}

	private boolean onHomeButtonPressed() {
		onBackPressed();
		return true;
	}

	@Override
	public void setContentView(final View view) {
		super.setContentView(view);
		compositionPlugin.onViewCreated(view);
		ButterKnife.bind(this);
	}

	@Override
	public void setContentView(final View view, final ViewGroup.LayoutParams params) {
		super.setContentView(view, params);
		compositionPlugin.onViewCreated(view);
		ButterKnife.bind(this);
	}

	@Override
	protected void onStart() {
		super.onStart();
		compositionPlugin.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();
		compositionPlugin.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		compositionPlugin.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
		compositionPlugin.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		compositionPlugin.onDestroy();
	}

	@Override
	protected void onNewIntent(final Intent intent) {
		super.onNewIntent(intent);
		compositionPlugin.onNewIntent(intent);
	}

	@Override
	public Context getContext() {
		return this;
	}
}

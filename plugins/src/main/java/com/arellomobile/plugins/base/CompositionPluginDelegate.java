package com.arellomobile.plugins.base;

import android.content.Intent;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Date: 07.12.2016
 * Time: 10:52
 *
 * @author Savin Mikhail
 */
public class CompositionPluginDelegate implements CompositionPlugin {

	public Collection<Plugin> plugins = new ArrayList<>();

	@Override
	public void attach(final Plugin plugin) {
		if (plugin != null) {
			plugins.add(plugin);
		}
	}

	@Override
	public void detach(final Plugin plugin) {
		if (plugin != null) {
			plugins.remove(plugin);
		}
	}

	@Override
	public void onCreate() {
		for (Plugin plugin : plugins) {
			plugin.onCreate();
		}
	}

	@Override
	public void onViewCreated(final View view) {
		for (Plugin plugin : plugins) {
			plugin.onViewCreated(view);
		}
	}

	@Override
	public void onStart() {
		for (Plugin plugin : plugins) {
			plugin.onStart();
		}
	}

	@Override
	public void onResume() {
		for (Plugin plugin : plugins) {
			plugin.onResume();
		}
	}

	@Override
	public void onPause() {
		for (Plugin plugin : plugins) {
			plugin.onPause();
		}
	}

	@Override
	public void onStop() {
		for (Plugin plugin : plugins) {
			plugin.onStop();
		}
	}

	@Override
	public void onDestroy() {
		for (Plugin plugin : plugins) {
			plugin.onDestroy();
		}
	}

	@Override
	public void onNewIntent(final Intent intent) {
		for (Plugin plugin : plugins) {
			plugin.onNewIntent(intent);
		}
	}
}

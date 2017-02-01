package com.arellomobile.plugins.base;

import android.content.Intent;
import android.view.View;

/**
 * Date: 07.12.2016
 * Time: 10:57
 *
 * @author Savin Mikhail
 */
public class GenericPlugin<T> implements Plugin {

	private final T delegate;

	public GenericPlugin(final T delegate) {
		this.delegate = delegate;
	}

	public T getDelegate() {
		return delegate;
	}

	@Override
	public void onCreate() {

	}

	@Override
	public void onViewCreated(final View view) {

	}

	@Override
	public void onStart() {

	}

	@Override
	public void onResume() {

	}

	@Override
	public void onPause() {

	}

	@Override
	public void onStop() {

	}

	@Override
	public void onDestroy() {

	}

	@Override
	public void onNewIntent(final Intent intent) {

	}
}

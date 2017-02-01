package com.arellomobile.plugins;

import android.widget.Toast;

import com.arellomobile.plugins.base.GenericPlugin;


/**
 * Date: 12.12.2016
 * Time: 9:18
 *
 * @author Savin Mikhail
 */
public class ToastErrorPlugin extends GenericPlugin<ContextProvider> implements ErrorPlugin<String> {


	public ToastErrorPlugin(final ContextProvider delegate) {
		super(delegate);
	}

	public void showError(String message) {
		Toast.makeText(getDelegate().getContext(), message, Toast.LENGTH_LONG).show();
	}

	@Override
	public void hideError() {

	}
}

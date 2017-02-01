package com.arellomobile.plugins;

import android.widget.Toast;

import com.arellomobile.plugins.base.GenericPlugin;


/**
 * Date: 12.12.2016
 * Time: 16:49
 *
 * @author Savin Mikhail
 */
public class MessagePlugin extends GenericPlugin<ContextProvider> {


	public MessagePlugin(final ContextProvider delegate) {
		super(delegate);
	}

	public void showMessage(CharSequence text) {
		Toast.makeText(getDelegate().getContext(), text, Toast.LENGTH_LONG).show();
	}
}

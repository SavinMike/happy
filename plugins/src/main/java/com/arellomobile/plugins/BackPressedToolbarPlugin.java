package com.arellomobile.plugins;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Date: 08.12.2016
 * Time: 17:01
 *
 * @author Savin Mikhail
 */
public class BackPressedToolbarPlugin extends ToolbarPlugin {

	public BackPressedToolbarPlugin(final AppCompatActivity delegate) {
		super(delegate);
	}

	@Override
	public void onViewCreated(final View view) {
		super.onViewCreated(view);

		ActionBar supportActionBar = getDelegate().getSupportActionBar();
		if (supportActionBar != null) {
			supportActionBar.setDisplayHomeAsUpEnabled(true);
		}
	}
}

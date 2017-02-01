package com.arellomobile.plugins;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.plugins.base.GenericPlugin;


/**
 * Date: 08.12.2016
 * Time: 16:49
 *
 * @author Savin Mikhail
 */
public class ToolbarPlugin extends GenericPlugin<AppCompatActivity> {

	private String title;

	public ToolbarPlugin(final AppCompatActivity delegate) {
		super(delegate);
	}

	@Override
	public void onViewCreated(final View view) {
		super.onViewCreated(view);
		Toolbar toolbar = getToolbar(view);
		if (toolbar != null) {
			getDelegate().setSupportActionBar(toolbar);
			if (!TextUtils.isEmpty(title)) {
				getDelegate().setTitle(title);
			}
		}
	}

	private Toolbar getToolbar(View view) {
		if (view instanceof Toolbar) {
			return (Toolbar) view;
		}

		if (view instanceof ViewGroup) {
			for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
				Toolbar toolbar = getToolbar(((ViewGroup) view).getChildAt(i));
				if (toolbar != null) {
					return toolbar;
				}
			}
		}

		return null;
	}

	public void setTitle(final String title) {
		this.title = title;
	}
}

package com.arellomobile.plugins;


import com.arellomobile.plugins.base.Plugin;

/**
 * Date: 12.12.2016
 * Time: 9:22
 *
 * @author Savin Mikhail
 */
public interface ErrorPlugin<T> extends Plugin {

	void showError(T message);

	void hideError();
}

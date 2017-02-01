package com.arellomobile.plugins.base;

/**
 * Date: 07.12.2016
 * Time: 10:50
 *
 * @author Savin Mikhail
 */
public interface CompositionPlugin extends Plugin {

	void attach(Plugin plugin);

	void detach(Plugin plugin);
}

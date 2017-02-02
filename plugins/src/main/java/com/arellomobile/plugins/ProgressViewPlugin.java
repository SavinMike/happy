package com.arellomobile.plugins;

import android.os.Build;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.plugins.base.SimplePlugin;


/**
 * Date: 12.12.2016
 * Time: 9:16
 *
 * @author Savin Mikhail
 */
public class ProgressViewPlugin extends SimplePlugin implements ProgressPlugin {

	private int progressId;
	private int contentId;
	private int containerId = -1;
	private ViewGroup container;
	private View content;
	private View progress;

	private int hideVisibility = View.GONE;

	public ProgressViewPlugin(final int progressId, final int contentId) {
		this.progressId = progressId;
		this.contentId = contentId;
	}

	public ProgressViewPlugin(final int progressId, final int contentId, final int containerId) {
		this.progressId = progressId;
		this.contentId = contentId;
		this.containerId = containerId;
	}

	public void setHideVisibility(final int hideVisibility) {
		this.hideVisibility = hideVisibility;
	}

	@Override
	public void onViewCreated(final View view) {
		super.onViewCreated(view);
		if (containerId != -1) {
			container = (ViewGroup) view.findViewById(containerId);
		}
		content = view.findViewById(contentId);
		progress = view.findViewById(progressId);
	}

	public void showProgress() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			if (container != null) {
				TransitionManager.beginDelayedTransition(container);
			}
		}

		content.setVisibility(hideVisibility);
		progress.setVisibility(View.VISIBLE);
	}

	public void hideProgress() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			if (container != null) {
				TransitionManager.beginDelayedTransition(container);
			}
		}

		content.setVisibility(View.VISIBLE);
		progress.setVisibility(hideVisibility);
	}
}

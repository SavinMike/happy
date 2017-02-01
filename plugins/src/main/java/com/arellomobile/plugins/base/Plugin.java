package com.arellomobile.plugins.base;

import android.content.Intent;
import android.view.View;

/**
 * Date: 07.12.2016
 * Time: 10:49
 *
 * @author Savin Mikhail
 */
public interface Plugin {

	void onCreate();

	void onViewCreated(View view);

	void onStart();

	void onResume();

	void onPause();

	void onStop();

	void onDestroy();

	void onNewIntent(Intent intent);
}

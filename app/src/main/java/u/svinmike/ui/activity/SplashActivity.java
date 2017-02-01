package u.svinmike.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;

import u.svinmike.R;
import u.svinmike.mvp.presenter.SplashPresenter;
import u.svinmike.mvp.view.SplashView;

public class SplashActivity extends BaseActivity implements SplashView {
	@InjectPresenter
	SplashPresenter splashPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
	}

	@Override
	public void showMainScreen() {
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}
}

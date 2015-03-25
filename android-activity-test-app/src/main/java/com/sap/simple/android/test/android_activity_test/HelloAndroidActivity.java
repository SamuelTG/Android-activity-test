package com.sap.simple.android.test.android_activity_test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class HelloAndroidActivity extends Activity {

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
	 */

	public final static String STRING_PAYLOAD = "Started from LaunchActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button launchNextButton = (Button) findViewById(R.id.btnNextActivity);
		launchNextButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				startActivity(LaunchActivity.makeIntent(HelloAndroidActivity.this, STRING_PAYLOAD));
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

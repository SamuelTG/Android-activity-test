package com.sap.simple.android.test.android_activity_test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

/**
 * This activity is started from HelloAdroidActivity. It reads the payload from the given bundle and displays it using a TextView.
 */

public class LaunchActivity extends Activity {
	/**
	 * Extras key for the payload.
	 */
	public final static String EXTRAS_PAYLOAD_KEY = "EXTRAS_PAYLOAD_KEY";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launch);

		final String stringPayload = getIntent().getStringExtra(EXTRAS_PAYLOAD_KEY);

		if (stringPayload != null) {
			((TextView) findViewById(R.id.txtDisplay)).setText(stringPayload);

		}
	}

	public static Intent makeIntent(Context context, String payload) {
		return new Intent(context, LaunchActivity.class).putExtra(EXTRAS_PAYLOAD_KEY, payload);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.launch, menu);
		return true;
	}

}

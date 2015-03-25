package com.sap.simple.android.test.android_activity_test.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;

import com.sap.simple.android.test.android_activity_test.HelloAndroidActivity;
import com.sap.simple.android.test.android_activity_test.R;

public class HelloAndroidActivityTest extends ActivityUnitTestCase<HelloAndroidActivity> {
	private Intent launchIntent;

	public HelloAndroidActivityTest() {
		super(HelloAndroidActivity.class);
	}

	public void testActivity() {
		HelloAndroidActivity activity = getActivity();
		assertNotNull(activity);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// Create an intent to launch target Activity
		launchIntent = new Intent(getInstrumentation().getTargetContext(), HelloAndroidActivity.class);
	}

	/**
	 * Tests the preconditions of this test fixture.
	 */
	@MediumTest
	public void testPreconditions() {
		// Start the activity under test in isolation, without values for savedInstanceState and
		// lastNonConfigurationInstance
		startActivity(launchIntent, null, null);
		final Button launchNextButton = (Button) getActivity().findViewById(R.id.btnNextActivity);

		assertNotNull("HelloAndroidActivity is null", getActivity());
		assertNotNull("LaunchNextButton is null", launchNextButton);
	}

	@MediumTest
	public void testLaunchNextActivityButton_labelText() {
		startActivity(launchIntent, null, null);
		final Button launchNextButton = (Button) getActivity().findViewById(R.id.btnNextActivity);

		final String expectedButtonText = "Next Activity";
		assertEquals("Unexpected button label text", expectedButtonText, launchNextButton.getText());
	}

	@MediumTest
	public void testNextActivityWasLaunchedWithIntent() {
		startActivity(launchIntent, null, null);
		final Button launchNextButton = (Button) getActivity().findViewById(R.id.btnNextActivity);
		// Because this is an isolated ActivityUnitTestCase we have to directly click the
		// button from code
		launchNextButton.performClick();

		// Get the intent for the next started activity
		final Intent intent = getStartedActivityIntent();
		// Verify the intent was not null.
		assertNotNull("Intent was not null", intent);
		// Verify that LaunchActivity was finished after button click
		assertTrue(isFinishCalled());

		final String payload = intent.getStringExtra(com.sap.simple.android.test.android_activity_test.LaunchActivity.EXTRAS_PAYLOAD_KEY);
		// Verify that payload data was added to the intent
		assertEquals("Payload is empty", HelloAndroidActivity.STRING_PAYLOAD, payload);
	}
}

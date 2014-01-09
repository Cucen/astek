package com.msi.android.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.androidquery.AQuery;

public class TestActivity extends Activity {

	private AQuery aq;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);

		// use activity to create the AQuery object
		// this set the activity as the "root"

		aq = new AQuery(this);

		aq.hardwareAccelerated11();

		// id(R.id.text) - point the current "view" to the TextView with
		// id=R.id.text
		// text("Hello") - call the corresponding methods to change it

		aq.id(R.id.text).text("Hello");


		// id(R.id.button) - switch to a different "view"
		// text("Click Me") - update the button text
		// clicked(this, "buttonClicked") - assign a listener to the button,
		// pass in the method name

		aq.id(R.id.button).text("Click Me").clicked(this, "buttonClicked");

	}

	public void buttonClicked(View button) {

		// update the text
		aq.id(R.id.text).text("Hello World");
		aq.id(R.id.button).width(200);

	}

}

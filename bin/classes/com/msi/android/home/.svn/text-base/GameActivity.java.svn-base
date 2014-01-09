package com.msi.android.home;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ImageButton;

public class GameActivity extends JSonParseActivity  {

	ImageButton imageButtonGame1;
	String packageName = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		url = urlip + configDir + "game.json";
		super.onCreate(savedInstanceState);

		setContentView(R.layout.game);

		String directory = "";

		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			directory = bundle.getString("directory");
			packageName = directory;

			PackageManager packageManager = getPackageManager();

			try {
				Intent intent = packageManager
						.getLaunchIntentForPackage(packageName);

				if (null != intent) {
					startActivity(intent);
				}

			} catch (ActivityNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}

package com.msi.android.home;

import android.os.Bundle;

public class DTVActivity extends VitamioPlayerActivity {

	@Override
	public void onCreate(Bundle icicle) {
		TAG = "DTVActivity";
		lookingpathparam = "dtvpath";
		super.onCreate(icicle);
	}
}

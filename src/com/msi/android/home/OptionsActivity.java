package com.msi.android.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OptionsActivity extends Activity implements
		RadioGroup.OnCheckedChangeListener, OnClickListener {
	RadioGroup radiogroup1;
	RadioButton r1, r2, r3,r4,r5,r6;
	private int radioCheckedId = -1;

	public static String language = "tr";
	
	public static String enc="Windows-1254";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.options);

		radiogroup1 = (RadioGroup) findViewById(R.id.QueGroup1);
		r1 = (RadioButton) findViewById(R.id.turkish);
		r2 = (RadioButton) findViewById(R.id.english);
		r3 = (RadioButton) findViewById(R.id.deutsch);
		r4 = (RadioButton) findViewById(R.id.azerbaycanca);
		r5 = (RadioButton) findViewById(R.id.arapca);
		r6 = (RadioButton) findViewById(R.id.farsca);
		
		r1.setOnClickListener(this);
		r2.setOnClickListener(this);
		r3.setOnClickListener(this);
		r4.setOnClickListener(this);	
		r5.setOnClickListener(this);
		r6.setOnClickListener(this);
		
		radiogroup1.setOnCheckedChangeListener(this);

		
		if (language.equals("tr")) {
			r1.setChecked(true);
		}

		if (language.equals("en")) {
			r2.setChecked(true);
		}
		if (language.equals("de")) {
			r3.setChecked(true);
		}
		if (language.equals("az")) {
			r4.setChecked(true);
		}
		if (language.equals("ar")) {
			r5.setChecked(true);
		}
		if (language.equals("fa")) {
			r6.setChecked(true);
		}
	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		try {
			radioCheckedId = checkedId;

			switch (radioCheckedId) {
			case R.id.turkish:
				language = "tr";
				enc="Windows-1254";
				break;
			case R.id.english:
				language = "en";
				enc="UTF-8";
				break;
			case R.id.deutsch:
				language = "de";
				enc="Cp1252";
				break;	
			case R.id.azerbaycanca:
				language = "az";
				enc="Cp1254";
			    break;
			case R.id.arapca:
				language = "ar";
				enc="Cp1256";
			    break;		
			case R.id.farsca:
				language = "fa";
				enc="Cp1256";
			    break;	
			default:
				break;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void onClick(View v) {
		finish();
	}
}

package com.msi.android.home;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.astek.util.ADBService;
import com.astek.util.JSonLanguageConfigFile;
import com.astek.util.JSonList;

public class AndroidActivity extends JSonParseActivity implements
		OnClickListener {

	ImageButton btnPhoto, btnMusic, btnMovie, btnDTV, btnNews, btnGame,
			btnSurvey, btnRoute, btnAdvertorial;

	TextView txtMovie;
	TextView txtDtv;
	TextView txtMusic;
	TextView txtAdvertorial;
	TextView txtInternet;
	TextView txtTripInfo;
	TextView txtSurvey;
	TextView txtGame;

	JSONObject jsonObject;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);

		btnPhoto = (ImageButton) findViewById(R.id.btnPhoto);
		btnMusic = (ImageButton) findViewById(R.id.btnMusic);
		btnMovie = (ImageButton) findViewById(R.id.btnMovie);
		btnDTV = (ImageButton) findViewById(R.id.btnDTV);
		btnNews = (ImageButton) findViewById(R.id.btnNews);
		btnGame = (ImageButton) findViewById(R.id.btnGame);
		btnSurvey = (ImageButton) findViewById(R.id.btnSurvey);
		btnRoute = (ImageButton) findViewById(R.id.btnRoute);
		btnAdvertorial = (ImageButton) findViewById(R.id.btnAdvertorial);

		txtMovie = (TextView) findViewById(R.id.txtMovie);
		txtDtv = (TextView) findViewById(R.id.txtTelevizyon);
		txtMusic = (TextView) findViewById(R.id.txtMuzik);
		txtAdvertorial = (TextView) findViewById(R.id.txtAdvertorial);
		txtInternet = (TextView) findViewById(R.id.txtInternet);
		txtTripInfo = (TextView) findViewById(R.id.txtTripInfo);
		txtSurvey = (TextView) findViewById(R.id.txtSurvey);
		txtGame = (TextView) findViewById(R.id.txtGame);

		btnPhoto.setOnClickListener(this);
		btnMusic.setOnClickListener(this);
		btnMovie.setOnClickListener(this);
		btnDTV.setOnClickListener(this);
		btnNews.setOnClickListener(this);
		btnGame.setOnClickListener(this);
		btnSurvey.setOnClickListener(this);
		btnRoute.setOnClickListener(this);
		btnAdvertorial.setOnClickListener(this);

		ADBService.adbStart();
	}

	@Override
	public void onResume() {
		super.onResume();

		url = urlip + configDir + "language" + OptionsActivity.language
				+ ".json";

		String enc = OptionsActivity.enc;
		parseJSon(url, enc);
		JSonList.setJsonArrayLanguage(jsonArray);

		try {
			int jsonObjectCount = jsonArray.length();
			for (int i = 0; i < jsonObjectCount; i++) {
				jsonObject = JSonList.getJsonArrayLanguage().getJSONObject(i);
				if (jsonObject.optString(JSonLanguageConfigFile.LANGUAGE)
						.equals(OptionsActivity.language)) {
					break;
				}
			}
		} catch (JSONException e) {

			e.printStackTrace();
		}

		String movie = jsonObject.optString(JSonLanguageConfigFile.MOVIE);
		String dtv = jsonObject.optString(JSonLanguageConfigFile.DTV);
		String music = jsonObject.optString(JSonLanguageConfigFile.MUSIC);
		String game = jsonObject.optString(JSonLanguageConfigFile.GAME);
		String internet = jsonObject.optString(JSonLanguageConfigFile.INTERNET);
		String tripinfo = jsonObject.optString(JSonLanguageConfigFile.TRIPINFO);
		String survey = jsonObject.optString(JSonLanguageConfigFile.SURVEY);
		String advetorial = jsonObject
				.optString(JSonLanguageConfigFile.ADVERTORIAL);

		// Log.v("########################", movie);

		/*
		 * System.out.println("OK"); // bu islemiyor cunku tabletlerin network
		 * karti dista String macaddress = MacAddress.getHex();
		 * 
		 * System.out.println("OK1"); // <uses-permission
		 * android:name="android.permission.READ_PHONE_STATE" /> eklenmesi
		 * gerekiyor TelephonyManager tm = (TelephonyManager) getBaseContext()
		 * .getSystemService(Context.TELEPHONY_SERVICE);
		 * System.out.println("OK2"); final String DeviceId, SerialNum,
		 * androidId; //DeviceId Samsung = 351846050087718 DeviceId =
		 * tm.getDeviceId(); System.out.println("OK3"); //androidId Samsung =
		 * 9cba75ed65526d30 androidId = Secure.getString(getContentResolver(),
		 * Secure.ANDROID_ID); System.out.println("OK3");
		 * 
		 * 
		 * System.out.println("macaddress '" +
		 * MacAddress.getHex()+"', DeviceId: '"
		 * +DeviceId+", androidId: '"+androidId+ "'");
		 */

		/*
		TelephonyManager tm = (TelephonyManager) getBaseContext()
				.getSystemService(Context.TELEPHONY_SERVICE);
		final String DeviceId;
		DeviceId = tm.getDeviceId();

		if (!DeviceId.equals("159454141012886")
				&& !DeviceId.equals("108131990139109")) {
			finish();
		}
*/
		txtMovie.setText(movie);
		txtDtv.setText(dtv);
		txtMusic.setText(music);
		txtAdvertorial.setText(advetorial);
		txtInternet.setText(internet);
		txtTripInfo.setText(tripinfo);
		txtSurvey.setText(survey);
		txtGame.setText(game);

	}

	public void onClick(View v) {
		Intent i = null;
		boolean start = true;

		if (v.getId() == R.id.btnMovie) {
			Bundle bundle = new Bundle();
			bundle.putString("readCategory", "videocategory");

			Intent newIntent = new Intent(this, GridViewActivity.class);
			i = new Intent(this, GridViewActivity.class);
			i.putExtras(bundle);

		} else if (v.getId() == R.id.btnNews) {
			i = new Intent(this, AdsActivity.class);
		} else if (v.getId() == R.id.btnDTV) {
			Bundle bundle = new Bundle();
			bundle.putString("readCategory", "tvcategory");

			Intent newIntent = new Intent(this, GridViewActivity.class);
			i = new Intent(this, GridViewActivity.class);
			i.putExtras(bundle);

			// i = new Intent(this, DTVJSonDizinActivity.class);
		} else if (v.getId() == R.id.btnMusic) {

			Bundle bundle = new Bundle();
			bundle.putString("readCategory", "musiccategory");

			Intent newIntent = new Intent(this, GridViewActivity.class);
			i = new Intent(this, GridViewActivity.class);
			i.putExtras(bundle);
			// i = new Intent(this, MusicJSonDizinActivity.class);
		} else if (v.getId() == R.id.btnPhoto) {
			i = new Intent(this, OptionsActivity.class);
		} else if (v.getId() == R.id.btnRoute) {
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("Bilgi");
			alertDialog.setCancelable(true);
			alertDialog.setMessage("Server Bulunamadý");
			alertDialog.setIcon(R.drawable.ic_launcher);
			alertDialog.show();

			start = false;
			// i = new Intent(this, TripInfoActivity.class);
		} else if (v.getId() == R.id.btnSurvey) {
			i = new Intent(this, SurveyActivity.class);
		} else if (v.getId() == R.id.btnGame) {
			Bundle bundle = new Bundle();
			bundle.putString("readCategory", "games");

			Intent newIntent = new Intent(this, GridViewActivity.class);
			i = new Intent(this, GridViewActivity.class);
			i.putExtras(bundle);
		} else if (v.getId() == R.id.btnAdvertorial) {
			Bundle bundle = new Bundle();
			bundle.putString("readCategory", "adv");

			Intent newIntent = new Intent(this, GridViewActivity.class);
			i = new Intent(this, GridViewActivity.class);
			i.putExtras(bundle);

		}

		if (start) {
			i.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(i);
		}
	}
}
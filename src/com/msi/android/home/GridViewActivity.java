package com.msi.android.home;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import com.astek.util.JSonList;
import com.msi.android.home.AppInfoAdapter.ViewHolder;

public class GridViewActivity extends JSonParseActivity {

	private GridView mGridMain;
	JSONObject jsonObject;
	int selectedPosition = 0;
	int getSelect = 0;
	String readCategory = "";

	private static int incScrollPos = 3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview);

		String readFile = "";

		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			readFile = bundle.getString("readFile");
			readCategory = bundle.getString("readCategory");
		}

		if (readFile == null || readFile.equals("")) {
			url = urlip + configDir + readCategory + ".json";
		} else {
			url = urlip + readFile;
		}

		String enc = OptionsActivity.enc;
		parseJSon(url, enc);
		JSonList.setJsonArrayLanguage(jsonArray);

		String category = "";
		String directory = "";
		String image = "";
		String readfile = "";
		String nameText = "";
		String filmdtvmusic = "";

		mGridMain = (GridView) findViewById(R.id.gvMain);
		Resources res = getResources();
		List<AppInfo> listAppInfo = new ArrayList<AppInfo>();

		try {
			int jsonObjectCount = jsonArray.length();
			for (int i = 0; i < jsonObjectCount; i++) {
				jsonObject = JSonList.getJsonArrayLanguage().getJSONObject(i);
				category = jsonObject.optString("category");
				image = jsonObject.optString("image");
				directory = jsonObject.optString("directory");
				readfile = jsonObject.optString("readfile");
				nameText = jsonObject.optString("nametext");
				filmdtvmusic = jsonObject.optString("filmdtvmusic");
				String imageUrl = urlip + image;

				
				URL url;

					url = new URL(imageUrl);
		
				InputStream is = url.openStream();
				Bitmap bMap = BitmapFactory.decodeStream(is);
				bMap.getWidth();
				bMap.getHeight();
				
				/*
				Bitmap bMap = BitmapFactory.decodeFile(imageUrl);
					*/	
				listAppInfo.add(new AppInfo(bMap, nameText, category, readfile,
						directory, filmdtvmusic));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mGridMain.setAdapter(new AppInfoAdapter(this, listAppInfo));

		OnItemClickListener mItemClickListener = new GridViewItemClickListener(
				this);
		mGridMain.setOnItemClickListener(mItemClickListener); // add a
																// ItemClickListener
		mGridMain.setVerticalScrollBarEnabled(false);
	}

	public void onButtonClick(final View view) {
		switch (view.getId()) {
		case R.id.nextButton:

			getSelect = mGridMain.getFirstVisiblePosition();

			selectedPosition = getSelect + incScrollPos;

			mGridMain.setSelection(selectedPosition);
			// Resources res = getResources();
			// List<AppInfo> listAppInfo = new ArrayList<AppInfo>();
			/*
			 * listAppInfo.add(new AppInfo(BitmapFactory.decodeResource(res,
			 * R.drawable.app_browser), "Internet")); listAppInfo.add(new
			 * AppInfo(BitmapFactory.decodeResource(res, R.drawable.app_clock),
			 * "Clock")); listAppInfo.add(new
			 * AppInfo(BitmapFactory.decodeResource(res,
			 * R.drawable.app_display), "Display"));
			 */
			// mGridMain.setAdapter(new AppInfoAdapter(this, listAppInfo));
			break;
		case R.id.previousButton:
			// mGridMain.smoothScrollToPosition(8);

			getSelect = mGridMain.getFirstVisiblePosition();

			selectedPosition = getSelect - incScrollPos;

			mGridMain.setSelection(selectedPosition);

			int count = mGridMain.getCount();
			break;
		case R.id.backButton1:
			finish();
			break;
		case R.id.homeButton1:
			Intent homeIntent = new Intent(this, AndroidActivity.class);
			homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			finish();
			startActivity(homeIntent);
			break;
		}
	}

	public class GridViewItemClickListener implements OnItemClickListener {

		GridViewActivity gridViewActivity;

		public GridViewItemClickListener(GridViewActivity gridViewActivity) {
			this.gridViewActivity = gridViewActivity;
		}

		public void onItemClick(AdapterView<?> parent, View view, int pos,
				long id) {
			ViewHolder holder = (ViewHolder) view.getTag();

			if (holder == null) {

				return;

			}

			if (!holder.readFile.getText().equals("")) {

				if (holder.filmdtvmusic.getText().equals("music")) {
					Bundle bundle = new Bundle();
					bundle.putString("readFile", holder.readFile.getText()
							.toString());
					String urlip = gridViewActivity.urlip;
					bundle.putString("urlip", urlip);

					Intent newIntent = new Intent(gridViewActivity,
							AudioPlayerActivity.class);
					newIntent.putExtras(bundle);
					startActivityForResult(newIntent, 0);
				} else {
					Bundle bundle = new Bundle();
					bundle.putString("readFile", holder.readFile.getText()
							.toString());

					Intent newIntent = new Intent(gridViewActivity,
							GridViewActivity.class);
					newIntent.putExtras(bundle);
					startActivityForResult(newIntent, 0);
				}
			} else {
				Bundle bundle = new Bundle();

				String directoryTmp = holder.directory.getText().toString();
				
				bundle.putString("directory", directoryTmp
						.toString());
				
				String urlip = gridViewActivity.urlip;
				bundle.putString("urlip", urlip);

				Intent newIntent = null;

				if (holder.filmdtvmusic.getText().equals("dtv")) {


					String urltv=""+holder.directory.getText();
					newIntent = new Intent(Intent.ACTION_MAIN);
					PackageManager manager = getPackageManager();
					newIntent = manager
							.getLaunchIntentForPackage("org.videolan.vlc");
					newIntent.addCategory(Intent.CATEGORY_LAUNCHER);
					newIntent.putExtra("itemLocation",
							urltv);
					newIntent.putExtra("itemName", holder.nameText.getText());
					newIntent.putExtra("isTV", true);
					startActivity(newIntent);

				}
				if (holder.filmdtvmusic.getText().equals("film")) {
					
					
					String urltv="http://"+urlip + holder.directory.getText();
					
					/*Toast.makeText(
							GridViewActivity.this,
							"Film path '" + urltv, Toast.LENGTH_SHORT).show();
					*/
					newIntent = new Intent(Intent.ACTION_MAIN);
					PackageManager manager = getPackageManager();
					newIntent = manager
							.getLaunchIntentForPackage("org.videolan.vlc");
					newIntent.addCategory(Intent.CATEGORY_LAUNCHER);
					newIntent.putExtra("itemLocation",
							urltv);
					newIntent.putExtra("itemName", holder.nameText.getText());
					newIntent.putExtra("isTV", false);
					startActivity(newIntent);
					/*newIntent = new Intent(gridViewActivity,
							VitamioVideoPlayer.class);*/
				}
				if (holder.filmdtvmusic.getText().equals("games")) {
					/*
					 * newIntent = new Intent(gridViewActivity,
					 * GameActivity.class);
					 */
					gameStart(holder.directory.getText().toString());
				}

				if (newIntent != null) {
					newIntent.putExtras(bundle);
					startActivityForResult(newIntent, 0);
				}
			}

			/*Toast.makeText(
					GridViewActivity.this,
					"You have clicked on item '" + holder.tvName.getText()
							+ "'", Toast.LENGTH_SHORT).show();
			*/
		}

	}

	public void gameStart(String packageName) {
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
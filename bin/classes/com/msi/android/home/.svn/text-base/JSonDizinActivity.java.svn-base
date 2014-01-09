package com.msi.android.home;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

public class JSonDizinActivity extends JSonParseActivity {

	public AQuery aq;
	public AQuery listAq;


	protected String url;
	protected Class clazz;
	protected String sendParam;
	protected String sendParamResim;
	protected String sendParamBaslik;
	protected String sendParamID;
	protected String jSonParamMedia;
	protected String jSonParamResim;
	protected String jSonParamBaslik;
	protected String jSonParamID;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_list_activity3);
		aq = new AQuery(this);
		
	}

	public void work() {

		aq.progress(R.id.progress).ajax(url, JSONObject.class, this,
				"renderNews");

	}

	private void addItems(JSONArray ja, List<JSONObject> items) {
		for (int i = 0; i < ja.length(); i++) {
			JSONObject jo = ja.optJSONObject(i);
			if (jo.has("image")) {
				items.add(jo);
			}
		}
	}

	public void renderNews(String url, JSONObject json, AjaxStatus status) {

		if (json == null)
			return;

		JSONArray ja = json.optJSONObject("responseData").optJSONArray("results");
		if (ja == null)
			return;

		items = new ArrayList<JSONObject>();
		addItems(ja, items);

		listAq = new AQuery(this);

		ArrayAdapter<JSONObject> aa = new ArrayAdapter<JSONObject>(this,
				R.layout.content_item_s, items) {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {

				if (convertView == null) {
					convertView = getLayoutInflater().inflate(
							R.layout.content_item_s, null);
				}
				
				JSONObject jo = getItem(position);

				AQuery aq = listAq.recycle(convertView);
				aq.id(R.id.name).text(
						jo.optString("titleNoFormatting", "Baslik Yok"));
				aq.id(R.id.meta).text(jo.optString("publisher", ""));

				String tb = jo.optString("image");
				aq.id(R.id.tb)
						.progress(R.id.progress)
						.image(tb, true, true, 0, 0, null,
								AQuery.FADE_IN_NETWORK, 1.0f);

				return convertView;

			}
		};
		aq.id(R.id.list).adapter(aa).itemClicked(this, "itemClicked");
	}

	public void itemClicked(AdapterView<?> parent, View view, int position,
			long id) {

		JSONObject jo = items.get(position);

		Bundle bundle = new Bundle();
		bundle.putString(sendParam, jo.optString(jSonParamMedia, ""));
		bundle.putString(sendParamResim, jo.optString(jSonParamResim, ""));
		bundle.putString(sendParamBaslik, jo.optString(jSonParamBaslik, ""));
		bundle.putString(sendParamID, jo.optString(jSonParamID, ""));

		Intent newIntent = new Intent(this.getApplicationContext(), clazz);
		newIntent.putExtras(bundle);
		startActivityForResult(newIntent, 0);

	}

}

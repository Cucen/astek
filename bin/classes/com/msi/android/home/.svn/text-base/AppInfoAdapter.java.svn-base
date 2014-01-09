package com.msi.android.home;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AppInfoAdapter extends BaseAdapter {
	private Context mContext;
	private List<AppInfo> mListAppInfo;

	public AppInfoAdapter(Context context, List<AppInfo> list) {
		mContext = context;
		mListAppInfo = list;
	}

	public int getCount() {
		return mListAppInfo.size();
	}

	public Object getItem(int position) {
		return mListAppInfo.get(position);
	}

	public long getItemId(int position) {
		return position;
	}


	public View getView(int position, View convertView, ViewGroup parent) {

		AppInfo entry = mListAppInfo.get(position);

		ViewHolder holder = null;

		if (convertView == null) {

			LayoutInflater inflater = LayoutInflater.from(mContext);

			convertView = inflater.inflate(R.layout.layout_appinfo, null);

			holder = new ViewHolder();

			holder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);

			holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
			
			holder.readFile = (TextView) convertView.findViewById(R.id.ReadFile);

			holder.category = (TextView) convertView.findViewById(R.id.Category);

			holder.nameText= (TextView)convertView.findViewById(R.id.nameText);
			
			holder.directory= (TextView)convertView.findViewById(R.id.Directory);
			
			holder.filmdtvmusic= (TextView)convertView.findViewById(R.id.FilmDtvMusic);
			
			convertView.setTag(holder);

		}

		else {

			holder = (ViewHolder) convertView.getTag();

		}

		holder.ivIcon.setImageBitmap(entry.getIcon());

		holder.tvName.setText(entry.getName());

		
		holder.category.setText(entry.getmCategory());
		holder.readFile.setText(entry.getmReadFile());

		holder.nameText.setText(entry.getName());
		holder.directory.setText(entry.getDirectory());
		holder.filmdtvmusic.setText(entry.getFilmDtvMusic());
		return convertView;

	}

	public static class ViewHolder {

		ImageView ivIcon;

		TextView tvName;
		
		TextView readFile;
		
		TextView category;
		
		TextView nameText;
		
		TextView directory;
		
		TextView filmdtvmusic;

	}

}

package com.msi.android.home;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ImageSliderActivity extends Activity {

	public int currentimageindex = 0;
	public int currentimageLength = 0;
	public String fileDir = "/mnt/sdcard/DCIM/Camera/";

	Timer timer;
	TimerTask task;
	ImageView slidingimage;

	private List<String> path = null;
	private List<String> fileList = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mygame);
		final Handler mHandler = new Handler();

		fileList = getDir("/mnt/sdcard/DCIM/Camera/");
		currentimageLength = fileList.size();

		// Create runnable for posting
		final Runnable mUpdateResults = new Runnable() {
			public void run() {

				AnimateandSlideShow();

			}
		};

		int delay = 1000; // delay for 1 sec.

		int period = 8000; // repeat every 4 sec.

		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {

			public void run() {

				mHandler.post(mUpdateResults);

			}

		}, delay, period);

	}

	public void onClick(View v) {

		finish();
		android.os.Process.killProcess(android.os.Process.myPid());
	}

	private void AnimateandSlideShow() {

		slidingimage = (ImageView) findViewById(R.id.ImageView3_Left);

		Bitmap myBitmap = BitmapFactory.decodeFile(fileDir
				+ fileList.get(currentimageindex % currentimageLength));
		slidingimage.setImageBitmap(myBitmap);

		currentimageindex++;

		Animation rotateimage = AnimationUtils.loadAnimation(this,
				R.anim.custom_anim);

		slidingimage.startAnimation(rotateimage);

	}

	private List<String> getDir(String dirPath)

	{

		List<String> item = new ArrayList<String>();

		path = new ArrayList<String>();

		File f = new File(dirPath);

		File[] files = f.listFiles();

		for (int i = 0; i < files.length; i++)

		{

			File file = files[i];

			path.add(file.getPath());

			item.add(file.getName());

		}

		return item;

	}

}
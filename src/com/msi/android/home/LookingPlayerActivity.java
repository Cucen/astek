package com.msi.android.home;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.VideoView;

public class LookingPlayerActivity extends Activity{

	public String TAG = "LookingPlayerActivity";

	private VideoView mVideoView;
	private ImageButton mPlay;
	private ImageButton mPause;
	private ImageButton mReset;
	private ImageButton mStop;
	private String current;

	private String lookingpath;
	
	public String lookingpathparam;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.video);
		mVideoView = (VideoView) findViewById(R.id.surface_view);

		// mPath.setText("rtsp://media2.kure.tv:1935/live/yumurcak2");

		Bundle bundle = this.getIntent().getExtras();
		lookingpath = bundle.getString(lookingpathparam);

		mPlay = (ImageButton) findViewById(R.id.play);
		mPause = (ImageButton) findViewById(R.id.pause);
		mReset = (ImageButton) findViewById(R.id.reset);
		mStop = (ImageButton) findViewById(R.id.stop);

		mPlay.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				playVideo();
			}
		});
		mPause.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				if (mVideoView != null) {
					mVideoView.pause();
				}
			}
		});
		mReset.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				if (mVideoView != null) {
					mVideoView.seekTo(20000);
				}
			}
		});
		mStop.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				if (mVideoView != null) {
					current = null;
					mVideoView.stopPlayback();
				}
			}
		});
		runOnUiThread(new Runnable() {
			public void run() {
				playVideo();

			}

		});
	}

	private void playVideo() {
		try {
			String path;
			path = "DCIM/Camera/sample.mp4";
			Log.v(TAG, "path: " + path);
			if (path == null || path.length() == 0) {

			} else {
				// If the path has not changed, just start the media player
				if (path.equals(current) && mVideoView != null) {
					mVideoView.start();
					mVideoView.requestFocus();
					return;
				}
				current = path;
				// c oooooooooooooooooooooooooooook onemli
				// mVideoView.setVideoPath(getDataSource(path));
				String dizin = Environment.getExternalStorageDirectory()
						.getAbsolutePath() + File.separator + path;
				// mVideoView.setVideoPath(dizin);
				mVideoView.setVideoPath(lookingpath);
				mVideoView.start();
				mVideoView.requestFocus();

			}
		} catch (Exception e) {
			Log.e(TAG, "error: " + e.getMessage(), e);
			if (mVideoView != null) {
				mVideoView.stopPlayback();
			}
		}
	}

}

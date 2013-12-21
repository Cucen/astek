/*
 * Copyright (C) 2011 VOV IO (http://vov.io/)
 */

package io.vov.android.vitamio.demo;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnPreparedListener;
import io.vov.vitamio.MediaPlayer.OnSubtitleUpdateListener;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class VideoViewDemo extends Activity {

	//private String path = "/mnt/sdcard/DCIM/Camera/sample.mp4";
	//private String path = "rtsp://dcdn.motiwe.com:80/dogantv/startv.stream";
	//private String path = "http://192.168.0.86:31339/0,002e,0207,02c6";
	
	private String path = "http://192.168.1.153/astek/tarkan.mp4";
	private VideoView mVideoView;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.videoview);
		mVideoView = (VideoView) findViewById(R.id.surface_view);
		mVideoView.setVideoPath(path);
		mVideoView.setOnPreparedListener(new OnPreparedListener() {

			public void onPrepared(MediaPlayer mp) {
				mVideoView.setSubPath("/sdcard/Video/238_mongoid.srt");
				mVideoView.setSubShown(true);
			}
		});
		mVideoView.setOnSubtitleUpdateListener(new OnSubtitleUpdateListener() {

			public void onSubtitleUpdate(String arg0) {
				Log.i("VitamioDemo", arg0);
			}

			public void onSubtitleUpdate(byte[] arg0, int arg1, int arg2) {
			}
		});
		mVideoView.setMediaController(new MediaController(this));
		mVideoView.requestFocus();
	}

	private int mLayout = VideoView.VIDEO_LAYOUT_ZOOM;

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		if (mVideoView != null)
			mVideoView.setVideoLayout(mLayout, 0);
		super.onConfigurationChanged(newConfig);
	}
}

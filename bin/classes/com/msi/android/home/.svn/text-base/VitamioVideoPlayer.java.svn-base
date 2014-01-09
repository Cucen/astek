package com.msi.android.home;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnBufferingUpdateListener;
import io.vov.vitamio.MediaPlayer.OnCompletionListener;
import io.vov.vitamio.MediaPlayer.OnPreparedListener;
import io.vov.vitamio.MediaPlayer.OnVideoSizeChangedListener;

import java.util.Timer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.astek.util.MyCount;

public class VitamioVideoPlayer extends Activity implements
		OnBufferingUpdateListener, OnCompletionListener, OnPreparedListener,
		OnVideoSizeChangedListener, SurfaceHolder.Callback,
		SeekBar.OnSeekBarChangeListener {

	private static final String TAG = "MediaPlayerDemo";
	private int mVideoWidth;
	private int mVideoHeight;
	private MediaPlayer mMediaPlayer;
	private SurfaceView mPreview;
	private SurfaceHolder holder;
	// private String path = "http://192.168.1.153/astek/tarkan.mp4";
	private String path = "/mnt/sdcard/Download/Dudu.mp4";

	private boolean mIsVideoSizeKnown = false;
	private boolean mIsVideoReadyToBePlayed = false;

	private ImageButton mPlay;

	private SeekBar songProgressBar;

	private Utilities utils;

	private Handler mHandler = new Handler();

	private TextView songCurrentDurationLabel;
	private TextView songTotalDurationLabel;

	private RelativeLayout linearLayout1;
	private RelativeLayout linearLayout2;

	private Handler mTimerHandler = new Handler();
	private Timer timer;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.mediaplayer);
		mPreview = (SurfaceView) findViewById(R.id.surface);
		holder = mPreview.getHolder();
		holder.addCallback(this);

		String directory = "";
		String urlip = "";

		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			urlip = bundle.getString("urlip");
			directory = bundle.getString("directory");
			path = urlip + directory;
		}

		mPlay = (ImageButton) findViewById(R.id.play);
		songProgressBar = (SeekBar) findViewById(R.id.songProgressBar);
		songCurrentDurationLabel = (TextView) findViewById(R.id.songCurrentDurationLabel);
		songTotalDurationLabel = (TextView) findViewById(R.id.songTotalDurationLabel);

		linearLayout1 = (RelativeLayout) findViewById(R.id.linearLayout1);
		linearLayout2 = (RelativeLayout) findViewById(R.id.linearLayout2);

		utils = new Utilities();
		songProgressBar.setOnSeekBarChangeListener(this); // Important

		songProgressBar.setProgress(0);
		songProgressBar.setMax(100);
		updateProgressBar();

		mPlay.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {

				filmStart();
			}
		});

	}

	public void filmStart() {
		if (mMediaPlayer.isPlaying()) {
			if (mMediaPlayer != null) {
				mMediaPlayer.pause();
				mPlay.setImageResource(R.drawable.play);
			}
		} else {
			if (mMediaPlayer != null) {
				startVideoPlayback();
				mPlay.setImageResource(R.drawable.pause);
			}
		}
	}

	private void playVideo() {
		doCleanUp();
		try {
			mMediaPlayer = new MediaPlayer(this);
			mMediaPlayer.setDataSource(path);
			mMediaPlayer.setDisplay(holder);
			mMediaPlayer.prepareAsync();
			mMediaPlayer.setScreenOnWhilePlaying(true);
			mMediaPlayer.setOnBufferingUpdateListener(this);
			mMediaPlayer.setOnCompletionListener(this);
			mMediaPlayer.setOnPreparedListener(this);
			mMediaPlayer.setOnVideoSizeChangedListener(this);

		} catch (Exception e) {
			Log.e(TAG, "error: " + e.getMessage(), e);
		}
	}

	public void onBufferingUpdate(MediaPlayer arg0, int percent) {
		Log.d(TAG, "onBufferingUpdate percent:" + percent);

	}

	public void onCompletion(MediaPlayer arg0) {
		Log.d(TAG, "onCompletion called");
		mMediaPlayer.release();
	}

	public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
		Log.v(TAG, "onVideoSizeChanged called");
		if (width == 0 || height == 0) {
			Log.e(TAG, "invalid video width(" + width + ") or height(" + height
					+ ")");
			return;
		}
		mIsVideoSizeKnown = true;
		mVideoWidth = width;
		mVideoHeight = height;
		if (mIsVideoReadyToBePlayed && mIsVideoSizeKnown) {
			startVideoPlayback();
		}
	}

	public void onPrepared(MediaPlayer mediaplayer) {
		Log.d(TAG, "onPrepared called");
		mIsVideoReadyToBePlayed = true;
		if (mIsVideoReadyToBePlayed && mIsVideoSizeKnown) {
			// startVideoPlayback();
			filmStart();
		}
	}

	public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k) {
		Log.d(TAG, "surfaceChanged called" + i + "  " + j + "   " + k);
	}

	public void surfaceDestroyed(SurfaceHolder surfaceholder) {
		Log.d(TAG, "surfaceDestroyed called");
	}

	public void surfaceCreated(SurfaceHolder holder) {
		Log.d(TAG, "surfaceCreated called");
		playVideo();
	}

	@Override
	protected void onPause() {
		super.onPause();
		releaseMediaPlayer();
		doCleanUp();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		releaseMediaPlayer();
		doCleanUp();
	}

	private void releaseMediaPlayer() {
		if (mMediaPlayer != null) {
			mMediaPlayer.release();
			mMediaPlayer = null;
		}

	}

	private void doCleanUp() {
		mVideoWidth = 0;
		mVideoHeight = 0;
		mIsVideoReadyToBePlayed = false;
		mIsVideoSizeKnown = false;
	}

	private void startVideoPlayback() {
		Log.v(TAG, "startVideoPlayback");
		holder.setFixedSize(mVideoWidth, mVideoHeight);
		mMediaPlayer.start();
	}

	/**
	 * Background Runnable thread
	 * */
	private Runnable mUpdateTimeTask = new Runnable() {
		public void run() {
			if (mMediaPlayer != null) {
				long totalDuration = mMediaPlayer.getDuration();
				long currentDuration = mMediaPlayer.getCurrentPosition();

				// Displaying Total Duration time
				songTotalDurationLabel.setText(""
						+ utils.milliSecondsToTimer(totalDuration));
				// Displaying time completed playing
				songCurrentDurationLabel.setText(""
						+ utils.milliSecondsToTimer(currentDuration));

				// Updating progress bar
				int progress = (int) (utils.getProgressPercentage(
						currentDuration, totalDuration));
				// Log.d("Progress", ""+progress);
				songProgressBar.setProgress(progress);

				// Running this thread after 100 milliseconds
				mHandler.postDelayed(this, 100);
			}
		}
	};

	public void onStartTrackingTouch(SeekBar seekBar) {
		// remove message Handler from updating progress bar
		mHandler.removeCallbacks(mUpdateTimeTask);
	}

	/**
	 * When user stops moving the progress hanlder
	 * */

	public void onStopTrackingTouch(SeekBar seekBar) {
		mHandler.removeCallbacks(mUpdateTimeTask);
		int totalDuration = (int) mMediaPlayer.getDuration();
		int currentPosition = utils.progressToTimer(seekBar.getProgress(),
				totalDuration);

		// forward or backward to certain seconds
		mMediaPlayer.seekTo(currentPosition);

		// update timer progress again
		updateProgressBar();
	}

	/**
	 * Update timer on seekbar
	 * */
	public void updateProgressBar() {
		mHandler.postDelayed(mUpdateTimeTask, 100);

	}

	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub

	}

	public void surfaceClick(View v) {

		if (v.getId() == R.id.surface) {

			// 0 is for visible
			linearLayout1.setVisibility(View.VISIBLE);
			linearLayout2.setVisibility(View.VISIBLE);

			MyCount counter = new MyCount(linearLayout1, linearLayout2, 5000,
					1000);
			counter.start();

		}
	}

	public void mpButtonClick(View v) {
		switch (v.getId()) {
		case R.id.backButton2:
			finish();
			break;
		case R.id.homeButton2:
			Intent homeIntent = new Intent(this, AndroidActivity.class);
			homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			finish();
			startActivity(homeIntent);
			break;
		}
	}

}
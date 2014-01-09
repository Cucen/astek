package com.astek.util;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.RelativeLayout;

public class MyCount extends CountDownTimer {
	
	RelativeLayout linearLayout1;
	RelativeLayout linearLayout2;
	public MyCount(RelativeLayout linearLayout1, RelativeLayout linearLayout2,long millisInFuture,
			long countDownInterval) {
		super(millisInFuture, countDownInterval);
		
		this.linearLayout1 = linearLayout1;
		this.linearLayout2 = linearLayout2;
	}

	@Override
	public void onFinish() {
		linearLayout1.setVisibility(View.INVISIBLE);
		linearLayout2.setVisibility(View.INVISIBLE);
	}

	@Override
	public void onTick(long millisUntilFinished) {
		//linearLayout1.setVisibility(1);
		
		// System.out.println("Left: " + millisUntilFinished / 1000);
	}
}

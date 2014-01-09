package com.msi.android.home;

import android.os.Bundle;

public class VideoJSonDizinActivity extends JSonDizinActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Okunacak JSon Video dosyasi
		url = urlip+configDir+"video.json";
		
		//Alt Activity'e gonderilecek parametre. VideoActivity'de okunan parametre videopath
		sendParam = "videopath";
		
		//JSon dosyasinda okunacak medya turu. Video dosyasi olacagi icin video
		jSonParamMedia = "video";
	
		//calistirilacak alt Activity. Once Dizin gosteriliyor sonra tiklanan 
		//liste ismine gore Video calistiriliyor.
		clazz = VideoActivity.class;
		work();
	}
}

package com.msi.android.home;

import android.os.Bundle;

public class MusicJSonDizinActivity extends JSonDizinActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Okunacak JSon Müzik dosyasi
		url = urlip+configDir+"muzik.json";
		
		//Alt Activity'e gonderilecek parametre. VideoActivity'de okunan parametre videopath
		sendParam = "musicpath";
		sendParamResim = "imagepath";
		sendParamID = "idpath";
		sendParamBaslik = "titlepath";
		
		//JSon dosyasinda okunacak medya turu. Video dosyasi olacagi icin video
		jSonParamMedia = "music";
		jSonParamResim = "image";
		jSonParamID = "id";
		jSonParamBaslik = "titleNoFormatting";
		
		//calistirilacak alt Activity. Once Dizin gosteriliyor sonra tiklanan 
		//liste ismine gore Video calistiriliyor.
		clazz = AudioPlayerActivity.class;
		work();
	}
}

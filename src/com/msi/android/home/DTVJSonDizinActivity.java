package com.msi.android.home;

import android.os.Bundle;

public class DTVJSonDizinActivity extends JSonDizinActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Okunacak JSon TV dosyasi
		url = urlip+configDir+"tv.json";
		
		//Alt Activity'e gonderilecek parametre. DTVActivity'de okunan parametre videopath
		sendParam = "dtvpath";
		
		//JSon dosyasinda okunacak medya turu. TV dosyasi olacagi icin video
		jSonParamMedia = "dtv";
	
		//calistirilacak alt Activity. Once Dizin gosteriliyor sonra tiklanan 
		//liste ismine gore TV calistiriliyor.
		clazz = DTVActivity.class;
		work();
	}
}

package com.astek.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class JSonParser {

	private static String result = null;
	private static HttpPost post = null;
	private static JSONObject jsonObject = null;
	/*
	public static JSONObject getJSonArray(String url, String enc) {

		try {
			String str = "";
			result = "";


			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream (url), enc );
			BufferedReader reader = new BufferedReader (inputStreamReader);
			
	
			while ((str = reader.readLine()) != null)
				result += str;

			jsonObject = new JSONObject(result);
			return jsonObject;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}
	*/	
	public static JSONObject getJSonArray(String url, String enc) {

		try {
			String str = "";
			result = "";

			HttpClient client = new DefaultHttpClient();
			post = new HttpPost(url);
			HttpResponse response = client.execute(post);
			InputStream input = response.getEntity().getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					input,enc), 32768);

			while ((str = reader.readLine()) != null)
				result += str;

			jsonObject = new JSONObject(result);
			return jsonObject;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

}
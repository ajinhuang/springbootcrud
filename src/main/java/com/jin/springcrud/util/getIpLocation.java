package com.jin.springcrud.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;


public class getIpLocation {
	public static String getAddressByIP(String strIP) {
		try {
			URL url = new URL("http://ip-api.com/json/"+strIP);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line = null;
			StringBuffer result = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			reader.close();
			String ipAddr = result.toString();
			try {
					JSONObject obj1= new JSONObject(ipAddr);
					if("success".equals(obj1.get("status").toString())){
						//JSONObject obj2= new JSONObject(obj1.get("content").toString());
						//JSONObject obj3= new JSONObject(obj2.get("address_detail").toString());
						return obj1.get("country").toString()+"  "+obj1.get("city").toString();
				}else{
					return "未知地点";
				}
			} catch (JSONException e) {
				e.printStackTrace();
				return "未知地点";
			}
			
		} catch (IOException e) {
			return "未知地点";
		}

	}
}


package com.qianfeng.red.biechipang.main.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.qianfeng.red.biechipang.application.MyApplication;

/**
 * 封装SharedPreference的工具类。
 *
 */
public class SharedPreferenceUtil {

	public static String SHARE_NAME = "SharedPreferences";

	private static SharedPreferences getPreference() {
		return MyApplication.getContext().getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
	}

	public static void putInt(String key, int value) {
		getPreference().edit().putInt(key, value).commit();
	}

	public static void putString(String key, String value) {
		getPreference().edit().putString(key, value).commit();
	}

	public static void putBoolean(String key, boolean value) {
		getPreference().edit().putBoolean(key, value).commit();
	}

	public static int getInt(String key, int defValue) {
		return getPreference().getInt(key, defValue);
	}

	public static String getString(String key, String defValue) {
		return getPreference().getString(key, defValue);
	}

	public static boolean getBoolean(String key, boolean defValue) {
		return getPreference().getBoolean(key, defValue);
	}

}


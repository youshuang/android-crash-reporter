/********************************************************************
 * �ļ����ƣ�CrashReporter.java
 * ������Ŀ���ƣ�CrashReporter
 * �����ˣ�youshuang
 * Copyright (c) 2014 . All rights reserved.
 ********************************************************************/
package cn.gyyx.android;

import android.content.Context;

public class CrashReporter {
	public static void init(final Context context,CrashLogCallBack callback) {
	    	Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
	  		if (localUncaughtExceptionHandler instanceof CrashHandler)
	  				return;
	  		Thread.setDefaultUncaughtExceptionHandler(new CrashHandler(context,callback, localUncaughtExceptionHandler));
	}

}

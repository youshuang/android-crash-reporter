/********************************************************************
* 文件名称：CrashHandler.java
* 所属项目名称：CrashReporter
* 创建人：youshuang
* Copyright (c) 2014 . All rights reserved.
********************************************************************/
package cn.gyyx.android;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.os.Bundle;

public class CrashHandler implements Thread.UncaughtExceptionHandler{

	private Context mContext ;
	private CrashLogCallBack mCallBack ;
	private Thread.UncaughtExceptionHandler defaultHandler;
	public CrashHandler(Context context,CrashLogCallBack callback ,Thread.UncaughtExceptionHandler handler ) {
		mContext = context ;
		//mCallBack = callback ;
		defaultHandler  = handler ;
		mCallBack = callback ;
	}
	
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		final Writer writer = new StringWriter();
		final PrintWriter pWriter = new PrintWriter(writer);
		ex.printStackTrace(pWriter);
		String stackTrace = writer.toString();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
		Bundle bundle = new Bundle();
		bundle.putString(G.APP_PACKAGE, mContext.getPackageName());
		bundle.putString(G.APP_VERSION, "");
		//bundle.putString(G.AVAILABLE_MEMORY,getAvailableInternalMemorySize());
		bundle.putString(G.EXCEPTION_CLASS,ex.getClass().getName());
		bundle.putString(G.EXCEPTION_TIME,  format.format(new Date()));
		bundle.putString(G.OS_VERSION, "");
		bundle.putString(G.STACK_TRACE, stackTrace);
		bundle.putString(G.THREAD_NAME, thread.getName());
		//mCallBack.handleCrashLog(bundle);
		//mCallBack = new CrashLogCallBackImpl();
		mCallBack.handleCrashLog(bundle);
		System.out.println(bundle);
		defaultHandler.uncaughtException(thread, ex);
		//System.exit(0);
		
	}
}


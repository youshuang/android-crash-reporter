/********************************************************************
* 文件名称：CrashCallBack.java
* 所属项目名称：CrashReporter
* 创建人：youshuang
* Copyright (c) 2014 . All rights reserved.
********************************************************************/
package cn.gyyx.android;

import android.os.Bundle;

public interface CrashLogCallBack {

	public void handleCrashLog(Bundle bundle);
}


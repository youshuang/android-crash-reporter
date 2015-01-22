android程序崩溃日志上传

实现原理：
    程序运行过程中如果存在没有try catch的异常，将会交给 Thread.UncaughtExceptionHandler去处理，通过继承该类，并且将默认的异常处理的的类设置为他的一个子类，在子类中对获取的异常信息进行上传到服务器或者做其他处理，最后再调用系统的异常处理类。一句话就是在系统处理之前我们对异常堆栈信息进行了自己的处理

使用方法：
  初始化：
  CrashReporter.init(getApplicationContext(), new CrashLogCallBack() {
			@Override
			public void handleCrashLog(Bundle bundle) {
				System.out.println(bundle);//输出捕获到的异常信息
				
			}
		});
这样就完成了异常捕获的工作，handleCrashLog这个方法是对捕获的异常信息进行处理的方法，可以上传到服务器等操作。
具体会输出哪些信息，可以看G.java类，可以自己再根据需要添加


注意：不要让Activity去实现CrashLogCallBack这个接口，建议采用上面提供的方法，如果方法体较长可以单独定义实现类
  

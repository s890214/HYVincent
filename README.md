#Julie Project Version

> **第三方模块声明**
>
> 本项目为个人学习用 Demo，除本人编写的代码外，包含以下第三方模块，版权归各自原作者所有：
>
> | 模块 | 标识 / 来源 | 上游许可证 |
> |---|---|---|
> | `libqrcode` | `com.xys.libzxing`（libZXing 二维码封装） | 上游未声明 |
> | `threedlayout` | [githubwing/ThreeDLayout](https://github.com/githubwing/ThreeDLayout) | 上游未声明 |
>
> 上述模块仅用于学习研究，未用于商业分发。如原作者对使用方式有异议，将移除对应模块。本人编写的其余代码默认保留所有权利。

</br></br>最近项目发布了新的版本，闲来无事，整理了一下平时收集的东西，算是做了个小项目，都是基础的东西，留着以后可以用，也能看看..免得再找..
###



###实体类生成插件 GsonFormat
</br>date:2016年11月19日21:36:58
</br>from:https://my.oschina.net/kooeasy/blog/479773
</br>使用：在实体类类名上选中，然后选择顶部菜单的 Code->generate 然后在弹出的输入框里面输入json，然后会自动生成相关的实体类 并包含相关的构造方法


###3D动画特效
</br>date:2016年10月24日10:57:44
</br>from:https://github.com/githubwing/ThreeDLayout/blob/master/README_CN.md
</br>翻转效果..


###解决android app方法数65535限制
</br>date:2016年10月21日12:06:22
</br>from:http://www.jianshu.com/p/f68b0b070c31

* 在项目app的build.gradle中的android{defaultConfig{xx}}配置
```java
android{
	defaultConfig{
		.........
		multiDexEnabled true
		........
	}
}
```
* 在MyApplication中重写attachBaseContext(Context base)方法
```java
/**
     * 目的：解决方法数65535限制
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
```


* 在项目的app的build.gradle中的dependencies{}中配置multidex
```java

  dependencies{
    ..................
     compile 'com.android.support:multidex:1.0.1' //http://www.jianshu.com/p/f68b0b070c31
    .................
  }

```



###Logger神器集成
</br>date:2016年10月21日11:38:34
</br>from: http://blog.csdn.net/yy1300326388/article/details/45825343
</br>og color config:http://blog.csdn.net/yy1300326388/article/details/45825123
* 在项目的app的build.gradle中的dependencies{}中配置logger
```java

  dependencies{
    ..................
     compile 'com.orhanobut:logger:1.8'
    .................
  }

```
* 更改之前的MyLog.java类
```java
package com.vincent.julie.logs;

import android.util.Log;

import com.orhanobut.logger.Logger;
import com.vincent.julie.app.Contants;

/**
 * 作者：david on 2016/3/22 10:14
 * <p/>
 * 联系QQ：986945193
 * <p/>
 * 微博：http://weibo.com/mcxiaobing
 */
public final class MyLog {
	/** all Log print on-off */
	private final static boolean all = Contants.LOG_SWITCH;
	/** info Log print on-off */
	private final static boolean i = true;
	/** debug Log print on-off */
	private final static boolean d = true;
	/** err Log print on-off */
	private final static boolean e = true;
	/** verbose Log print on-off */
	private final static boolean v = true;
	/** warn Log print on-off */
	private final static boolean w = true;
	/** default print tag */
	private final static String defaultTag = "LogUtil-->";
	
	private MyLog() throws UnsupportedOperationException{

	};

	/**
	 * info Log print,default print tag
	 * 
	 * @param msg
	 *            :print message
	 */
	public static void i(String msg) {
		if (all && i) {
//			android.util.Log.i(defaultTag, msg);
			Logger.i(defaultTag,msg);
		}
	}

	/**
	 * info Log print
	 * 
	 * @param tag
	 *            :print tag
	 * @param msg
	 *            :print message
	 */
	public static void i(String tag, String msg) {
		if (all && i) {
//			android.util.Log.i(tag, msg);
			Logger.i(tag,msg);
		}
	}

	/**
	 * debug Log print,default print tag
	 * 
	 * @param msg
	 *            :print message
	 */
	public static void d(String msg) {
		if (all && d) {
//			android.util.Log.d(defaultTag, msg);
			Logger.d(defaultTag,msg);
		}
	}

	/**
	 * debug Log print
	 * 
	 * @param tag
	 *            :print tag
	 * @param msg
	 *            :print message
	 */
	public static void d(String tag, String msg) {
		if (all && d) {
//			android.util.Log.d(tag, msg);
			Logger.d(tag,msg);
		}
	}

	/**
	 * err Log print,default print tag
	 * 
	 * @param msg
	 *            :print message
	 */
	public static void e(String msg) {
		if (all && e) {
			try {
//				android.util.Log.e(defaultTag, msg);
				Logger.e(defaultTag,msg);
			} catch (Exception e1) {
				// TOdO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * err Log print
	 * 
	 * @param tag
	 *            :print tag
	 * @param msg
	 *            :print message
	 */
	public static void e(String tag, String msg) {
		if (all && e) {
			android.util.Log.e(tag, msg);
			Logger.e(tag,msg);
		}
	}

	/**
	 * verbose Log print,default print tag
	 * 
	 * @param msg
	 *            :print message
	 */
	public static void v(String msg) {
		if (all && v) {
//			android.util.Log.v(defaultTag, msg);
			Logger.v(defaultTag,msg);
		}
	}

	/**
	 * verbose Log print
	 * 
	 * @param tag
	 *            :print tag
	 * @param msg
	 *            :print message
	 */
	public static void v(String tag, String msg) {
		if (all && v) {
//			android.util.Log.v(tag, msg);
			Logger.v(tag,msg);
		}
	}

	/**
	 * warn Log print,default print tag
	 * 
	 * @param msg
	 *            :print message
	 */
	public static void w(String msg) {
		if (all && w) {
//			android.util.Log.w(defaultTag, msg);
			Logger.w(defaultTag,msg);
		}
	}

	/**
	 * warn Log print
	 * 
	 * @param tag
	 *            :print tag
	 * @param msg
	 *            :print message
	 */
	public static void w(String tag, String msg) {
		if (all && w) {
//			android.util.Log.w(tag, msg);
			Logger.w(tag,msg);
		}
	}

}

```
* 使用之前在MyApplication中的onCreate方法中初始化
```java
  @Override
    public void onCreate() {
        super.onCreate();
        //Logger.init(String tag);
        Logger.init("Julie");
   }
```

* 如果想使用更加绚丽的效果，可以自定义各等级日志的字体颜色
</br>AndroidStudio配置：
</br>1、File->Settings 或Ctrl + Alt +S
</br>2、找到 Editor -> Colors &Fonts -> Android Logcat 或在上面的搜索框中输入Logcat
</br>3、点中Verbose , Info, Debug等选项，然后在后面将Use Inberited attributes 去掉勾选
</br>4、再将 Foreground 前的复选框选上，就可以双击后面的框框去选择颜色了
</br>5、Apply–>OK

###极光推送集成
date:2016年10月19日12:56:56
</br>m:https://github.com/HYVincent/Julie/edit/master/README.md 集成了小米华为魅族激光推送的库
极光推送版本：2.2.0 lib下载：http://pan.baidu.com/s/1geJCIcj
</br>集成平台：Android
</br>jdk：java 1.8
</br>开发环境：AndroidStudio2.2.1
</br>效果：http://blog.csdn.net/pkandroid/article/details/52858546
</br>使用极光推送需要在极光推送官网注册，创建App，获取AppKey(AppKey=xxxxxxxxxxxxxxxxxxxxxxxxx)
</br>把下载的资源中的libs全部复制到Julie/app下面,需要在julie\app\build.gradle里面的android{}中配置：
```java
  android{
     .......
     sourceSets{
        main{
            jniLibs.srcDirs = ['libs']
        }
    }
}
```
</br>在项目的AndroidMainfest.xml中配置（配置不全可能会导致获取不到RegistrationId，推送失败）：
```java
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.vincent.julie">

    <uses-permission android:name="android.permission.READ_SMS"/>//读取信息
    <uses-permission android:name="android.permission.CAMERA"/>//相机
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />//开机自启动
    <uses-permission android:name="android.permission.BIND_JOB_SERVICE"/>

    <permission
        android:name="${applicationId}.permission.JPUSH_MESSAGE"
        android:protectionLevel="signature" />//如果没有配置此权限会导致收不到推送

    <!-- Required  一些系统要求的权限，如访问网络等-->
    <uses-permission android:name="${applicationId}.permission.JPUSH_MESSAGE" />
    <uses-permission android:name="android.permission.RECEIVE_USER_PRESENT" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />//读取手机状态
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />//读取外部存储
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WRITE_SETTINGS" />
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />



    <!-- Optional for location -->
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_LOCATION_EXTRA_COMMANDS" />
    <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
    <uses-permission android:name="android.permission.GET_TASKS" />


    <application
        android:name=".app.MyApplication"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".ui.activity.SecondsOpenAppActivity"
            android:theme="@style/SplashTheme">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".ui.activity.GuideActivity" />
        <activity android:name=".ui.activity.MainActivity"
            android:launchMode="singleTask"/>
        <activity android:name=".ui.activity.WelcomActivity" />
        <activity android:name=".ui.activity.PhoneInfoActivity"/>
        <activity android:name=".ui.activity.QrScodeUtilsActivity"/>
        <activity android:name=".ui.activity.SettingActivity"/>
        <activity android:name=".ui.activity.RxJavaTestActivity"/>
        <activity android:name=".ui.activity.RetrofitActivity"/>
        <activity android:name=".ui.activity.OkGoActivity"/>
        <activity android:name=".ui.activity.JiGuangPushActivity"/>
        <activity android:name=".ui.activity.PushMessageActivity"/>

        <!--Service 相关-->
        <!--priority 配置Service优先级 1000为最高-->
        <service
            android:name=".service.JulieService"
            android:enabled="true"
            android:persistent="true"
            android:priority="1000"
            android:exported="true">
        </service>

        <service android:name=".service.JobCastielService"
            android:enabled="true"
            android:persistent="true"
            android:priority="1000"
            android:permission="android.permission.BIND_JOB_SERVICE">
        </service>

        <service
            android:name=".service.ProtectService"
            android:enabled="true"
            android:persistent="true"
            android:process="com.vincent.julie.service.ProtectService"
            android:priority="1000">
        </service>
        <!--广播-->
        <receiver android:name=".reciver.BootBroadcastReceiver">
            <intent-filter>
                <action android:name="android.intent.action.BOOT_COMPLETED" />
                <category android:name="android.intent.category.HOME" />
            </intent-filter>
        </receiver>

        <!--极光推送配置-->

        <!-- Rich push 核心功能 since 2.0.6-->
        <activity
            android:name="cn.jpush.android.ui.PopWinActivity"
            android:theme="@style/MyDialogStyle"
            android:exported="false" >
        </activity>

        <!-- Required SDK核心功能-->
        <activity
            android:name="cn.jpush.android.ui.PushActivity"
            android:configChanges="orientation|keyboardHidden"
            android:theme="@android:style/Theme.NoTitleBar"
            android:exported="false">
            <intent-filter>
                <action android:name="cn.jpush.android.ui.PushActivity" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="${applicationId}" />
            </intent-filter>
        </activity>
        <!-- Required  SDK核心功能-->
        <service
            android:name="cn.jpush.android.service.DownloadService"
            android:enabled="true"
            android:exported="false" >
        </service>


        <!-- Required SDK 核心功能-->
        <!-- 可配置android:process参数将PushService放在其他进程中 -->
        <service
            android:name="cn.jpush.android.service.PushService"
            android:enabled="true"
            android:exported="false">
            <intent-filter>
                <action android:name="cn.jpush.android.intent.REGISTER" />
                <action android:name="cn.jpush.android.intent.REPORT" />
                <action android:name="cn.jpush.android.intent.PushService" />
                <action android:name="cn.jpush.android.intent.PUSH_TIME" />
            </intent-filter>
        </service>

        <!-- Required SDK核心功能-->
        <receiver
            android:name="cn.jpush.android.service.PushReceiver"
            android:enabled="true"
            android:exported="false">
            <intent-filter android:priority="1000">
                <action android:name="cn.jpush.android.intent.NOTIFICATION_RECEIVED_PROXY" />   <!--Required  显示通知栏 -->
                <category android:name="${applicationId}" />
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.USER_PRESENT" />
                <action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
            </intent-filter>
            <!-- Optional -->
            <intent-filter>
                <action android:name="android.intent.action.PACKAGE_ADDED" />
                <action android:name="android.intent.action.PACKAGE_REMOVED" />
                <data android:scheme="package" />
            </intent-filter>

        </receiver>

        <!-- Required SDK核心功能-->
        <receiver android:name="cn.jpush.android.service.AlarmReceiver" android:exported="false"/>

        <!-- User defined.  For test only  用户自定义的广播接收器-->
        <receiver
            android:name=".reciver.JiGuangPushReceiver"//自定义的推送消息处理类
            android:exported="false"
            android:enabled="true">
            <intent-filter>
                <action android:name="cn.jpush.android.intent.REGISTRATION" /> <!--Required  用户注册SDK的intent-->
                <action android:name="cn.jpush.android.intent.MESSAGE_RECEIVED" /> <!--Required  用户接收SDK消息的intent-->
                <action android:name="cn.jpush.android.intent.NOTIFICATION_RECEIVED" /> <!--Required  用户接收SDK通知栏信息的intent-->
                <action android:name="cn.jpush.android.intent.NOTIFICATION_OPENED" /> <!--Required  用户打开自定义通知栏的intent-->
                <action android:name="cn.jpush.android.intent.ACTION_RICHPUSH_CALLBACK" /> <!--Optional 用户接受Rich Push Javascript 回调函数的intent-->
                <action android:name="cn.jpush.android.intent.CONNECTION" /><!-- 接收网络变化 连接/断开 since 1.6.3 -->
                <category android:name="${applicationId}" />
            </intent-filter>
        </receiver>


        <!-- Required  . Enable it you can get statistics data with channel -->
        <meta-data android:name="JPUSH_CHANNEL" android:value="developer-default"/>
        <meta-data android:name="JPUSH_APPKEY" android:value="xxxxxxxxxxxxxxxx" /> <!--  </>值来自开发者平台取得的AppKey-->

    </application>

</manifest>

```
####配置以及主要类详解：
</ba>1、在MyApplication中onCreate()方法中初始化，以及设置调试日志开关
```java
        JPushInterface.setDebugMode(true);//测试模式，打开调试日志
        JPushInterface.init(getApplicationContext());//JPush初始化
```
</ba>2、JiGuangPushReceiver,此广播接受处理推送消息（从Example中把MyReceiver类靠过来改一下名称即可，JiGuangPushReceiver中增加了对定义的消息处理，具体参见项目详情）
</ba>3、JiGuangPushActivity类，初始化JPush（其实已经初始化过了，在MyApplication中，这个类主要是查看RegistrationId有没有生成成功，刚开始配置清单里面没配置好，RegistrationId没有生成，导致推送消息接收不了）
</ba>4、PushMessageActivity类，自定义消息处理类，发送自定义消息的时候，点击通知栏的消息，会跳转到此类，查看具体消息详情，只是做了个例子，处理不多，</ba>消息采用Intent携带数据跳转
#####添加NotificationUtils工具类，传递参数，发送通知到顶部通知栏
</ba>void sendNotification(Context context, String activity, int imgId, String title, String msg);
</br>context：上下文对象
</br> activity：点击消息此跳转到Activity，的传入Activity必须包含的完整包名、类型，具体实现为反射
</br> imgId：通知的图标
</br> title：通知的标题
</br> msg：通知的内容

###增加对Retrolambda的支持，增加对RxJava的支持,增加Retrofit网络框架支持
date:2016年10月17日12:54:03</br>
Retrolambda介绍：http://blog.csdn.net/cai_iac/article/details/50846139 
</br>Demo:https://github.com/evant/gradle-retrolambda
</br>RxJava介绍：http://gank.io/post/560e15be2dca930e00da1083#toc_1
####Retrolambda使用集成：</br>
  1、在外部build.gradle中的dependencies{}配置：
```java
   dependencies {
        classpath 'com.android.tools.build:gradle:2.2.1'
        classpath 'me.tatarka:gradle-retrolambda:3.3.0'//retrolambda 支持java1.8语法
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8' 
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
```
  
  2、在app的build.gradle的顶部加入：
```java
  apply plugin: 'com.android.application'
  apply plugin: 'com.neenbedankt.android-apt'
  apply plugin: 'me.tatarka.retrolambda' //retrolambda 插件声明 设置说明：http://www.open-open.com/lib/view/open1433898197176.html
```
</br>在app的build.gradle的android{}中配置： 
```java  
  retrolambda {
        println("JAVA_HOME: " + System.getenv("JAVA_HOME"))
        println("JAVA7_HOME: " + System.getenv("JAVA7_HOME"))
        println("JAVA8_HOME: " + System.getenv("JAVA8_HOME"))
        javaVersion JavaVersion.VERSION_1_7
    }
    /**
     * 加入compileOptions,这会让IDE使用用JAVA8语法解析
     */
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    /**
     * 指定将源码编译的级别,，使用下列代码，会将代码编译到兼容1.6的字节码格式
     */
    retrolambda {
        javaVersion JavaVersion.VERSION_1_6
    }
```
  
  </br>设置说明：http://www.open-open.com/lib/view/open1433898197176.html
  </br>3、在app的build.gradle中的dependencies{}引入：
  
```java
  dependencies{
   //Retrolambda的使用 设置说明：http://www.open-open.com/lib/view/open1433898197176.html
    compile 'me.tatarka:gradle-retrolambda:3.3.0'
   //Android开发之RxJava和RxAndroid RxJava说明:http://gank.io/post/560e15be2dca930e00da1083#toc_1
    compile 'io.reactivex:rxjava:1.2.1'
    compile 'io.reactivex:rxandroid:1.2.1'
    //retrofit网络访问框架
    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'
  //compile 'com.squareup.retrofit:adapter-rxjava:2.0.0-beta2'
  }
```
 
####Retrolambda使用说明：
```java
        //使用Retrolambda插件之前的写法
       tvRetrolambdaTest.setOnClickListener(new View.OnClickListener() {//使用Retrolambda插件之前的写法
            @Override
            public void onClick(View v) {
                ToastUtils.showSingleTextToast(RxJavaTestActivity.this,"Retrolambda学习，弹出来一个Toast");
            }
        });
        //使用Retrolambda插件之后的写法
        tvRetrolambdaTest.setOnClickListener(view -> ToastUtils.showSingleTextToast(this, "Retrolambda学习，弹出来一个Toast"));
```
####RxJava使用
1、RxJava的使用配置：
</br>配置在上面...
2、RxJava的使用：
</br>.....</br>
####Retrofit网络框架请求聚合天气数据
* 建立天气实体类WeatherEntity.class
```java
 package com.vincent.julie.retrofit.model;

/**
 * 项目名称：Julie
 * 类名：com.vincent.julie.entity
 * 类描述：
 * 创建人：Vincent QQ:1032006226
 * 创建时间：2016/10/17 16:43
 * 修改人：
 * 修改时间：
 * 修改备注：
 * 十月
 */

public class WeatherEntity {

    private String resultcode;//响应状态码  200-->获取数据成功
    private String reason;// successed  响应状态
    private String error_code;//错误码
    private result result;

    public WeatherEntity.result getResult() {
        return result;
    }

    public void setResult(WeatherEntity.result result) {
        this.result = result;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public static class result{
        private today today;
        private sk sk;

        public WeatherEntity.result.today getToday() {
            return today;
        }

        public void setToday(WeatherEntity.result.today today) {
            this.today = today;
        }

        public WeatherEntity.result.sk getSk() {
            return sk;
        }

        public void setSk(WeatherEntity.result.sk sk) {
            this.sk = sk;
        }

        public class sk{
            private String temp;//28
            private String wind_direction;//东北风
            private String wind_strength;//1级
            private String humidity;//"69%
            public String time;//时间
        }
        public class today{
            private String wind;//威风
            private String week;//星期一

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }
        }
    }

}
```
* 创建请求接口WeatherApiService.class
```java
package com.vincent.julie.retrofit;

import com.vincent.julie.retrofit.model.WeatherEntity;
import com.vincent.julie.retrofit.response.GetWeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * 项目名称：Julie
 * 类名：com.vincent.julie.listener
 * 类描述：
 * 创建人：Vincent QQ:1032006226
 * 创建时间：2016/10/17 16:39
 * 修改人：
 * 修改时间：
 * 修改备注：
 * 十月
 */

public interface WeatherApiService {
//天气地址：http://v.juhe.cn/weather/index?format=2&cityname=深圳&key=77a262c554de40916edc78858221b4a9
/*
    @GET("weather/index")
    Observable<GetWeatherData> getWeatherData(@Query("format") String format, @Query("cityname" )String cityname, @Query("key")String appKey);
*/
    @GET("weather/index")
    Call<WeatherEntity> getWeatherData(@Query("format")String format, @Query("cityname")String cityname, @Query("key")String appKey);

}

```
* 在RetrofitActivity.class中发起请求

```java
Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApiService weatherApiService=retrofit.create(WeatherApiService.class);
        final Call<WeatherEntity> call=weatherApiService.getWeatherData("2","深圳","77a262c554de40916edc78858221b4a9");
        new Thread(){
            @Override
            public void run() {
                try{
                    Response<WeatherEntity> bodayResponse=call.execute();
                    weatherEntity=bodayResponse.body();
                    MyLog.d("data",weatherEntity.getReason()+","+weatherEntity.getError_code()+","+weatherEntity.getResult().toString());
                    ToastUtils.showSingleTextToast(MyApplication.getInstance(),weatherEntity.getReason());
                    WeatherEntity.result.today today=weatherEntity.getResult().getToday();
                    MyLog.d("today",today.toString());
                    Message message=Message.obtain();
                    message.obj=weatherEntity;
                    message.arg1=0;
                    handler.sendMessage(message);
                }catch (IOException e){
                    e.printStackTrace();
                }catch (Exception e){
                    MyLog.d("data",weatherEntity.getReason()+","+weatherEntity.getError_code());
                    e.printStackTrace();
                }
            }
        }.start();
```
在handle的handleMessage（Message message）方法中处理tvShowWeather显示数据更新，这里只处理了星期
```java
if(msg.arg1==0){
                WeatherEntity weatherEntity=(WeatherEntity) msg.obj;
                tvShowWeather.setText(weatherEntity.getResult().getToday().getWeek());
            }
```


###收录了一个加密解密类
原文地址：http://blog.csdn.net/gzejia/article/details/52755332
</br>看了下，还不错，收藏了


###push log:增加一个自定义View，

from:http://gold.xitu.io/post/57fb97412e958a005596cab9 </br>
看到这个自定义View还不错，加进来，哈
* 添加自定义View：AnFQNumEditText，限制输入字数

###commit log:增加对华为手机管家的各种跳转
效果图:我的blog： [ 跳转到华为手机管家悬浮窗管理页面 ]( http://blog.csdn.net/pkandroid/article/details/52014653 )
</br>date: 2016年10月13日20:34:18
* 跳转到华为手机管家内存清理页面
* 跳转到华为手机管家权限管理页面
* 跳转到华为手机管家通知管理页面
* 跳转到华为手机管家悬浮窗管理页面
* 跳转到华为手机管家骚扰拦截管理页面
* 跳转到华为手机管家受保护app管理页面
* 跳转到华为手机管家自启动权限管理页面
* 跳转到华为手机管家 关联启动权限管理页面（失败，系统禁止）

###commit log: JobCastielService 定时任务

date: 2016年10月11日00:00:27
* 添加类：JobCastielService 此类的onStart和onStop方法 作用：在杀掉Service之后启动定时任务启动JulieService，后台保活 测试：在荣耀6 android6.0 EMUI4.0.1_H60-L02_6.10.1可实现开机就运行，直到关机，荣耀8不行，会认为是关联启动

###初次概况
date: 2016年9月28 15:22:55
* MD5加密工具类
* 第一次进入引导页
* 欢迎页面停留显示2s
* Volley网络请求封装
* 侧滑菜单，自定义SlidingMenu实现
* 顶部状态栏颜色配置，可兼容android4.4+
* 封装title，保证风格统一，所有继承BaseActivity的Activity均自带title
* 二维码扫描、文字二维码生成，带logo的二维码生成，二维码分享（调用系统分享并保存到手机）
* 开机自启动（需要权限ps:我的手机版本bug，可开机自启动，华为荣耀6，H60-L02 EMUI4.0.1_H60-L02_6.10.1）
* 适配Android6.0之后的权限机制：permissionsdispatcher插件（不管用户是否采取哪种操作，都能给用户以提示）
* 底部4个tab切换，监听Fragment的返回事件，判定首个Fragment才能退出，类似京东首页退出效果，退出方式为2s内连点两下
* butterknife(8.4.0注解，使用方式：在setContentView的布局上右键#Generate，然后点击Generate Butterknife Injections）
* 手机信息收集：手机厂商、手机型号、SDK版本、系统版本、基带版本、内核版本、内部版本、cpu信息、屏幕宽度、屏幕高度、all运行内存、可用运行内存、IMEI号码、内置SD卡可用大小、内置SD卡大小、屏幕分辨率、是否root
* JulieService会在后台循环播放一段无声MP3来保证JulieService不被系统kill，此方法在华为手机中估计是都能实现的，而且还能避免锁屏之后被系统杀死！ps:最好是能加入到华为手机管家受保护应用中去，那样效果更好啦,更多关于后台保活地址：http://www.jianshu.com/p/d791bbede02c




package org.easydarwin.easyplayer;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.tencent.bugly.crashreport.CrashReport;

import org.easydarwin.easyplayer.data.EasyDBHelper;
import org.easydarwin.video.Client;

/**
 * Application
 *
 * Created by afd on 8/13/16.
 */
public class TheApp extends Application {

    public static SQLiteDatabase sDB;
    public static int activeDays = 9999;

    @Override
    public void onCreate() {
        super.onCreate();

        activeDays = Client.getActiveDays(this, BuildConfig.RTSP_KEY);
        sDB = new EasyDBHelper(this).getWritableDatabase();

        CrashReport.initCrashReport(getApplicationContext(), "045f78d6f0", BuildConfig.DEBUG);
    }
}

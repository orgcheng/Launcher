package com.gionee.amisystem.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.gionee.amisystem.APP;

import java.lang.reflect.Constructor;

import dalvik.system.PathClassLoader;

/**
 * Created by Administrator on 2017/4/12.
 */

public class Utils {
    public static View getYourPage() {
        Context hostContext = APP.getAppContext();
        try {
            Context pluginContext = hostContext.createPackageContext(Constants.PLUGIN_PACKAGE_NAME,Context.CONTEXT_IGNORE_SECURITY | Context.CONTEXT_INCLUDE_CODE);
            String apkPath = pluginContext.getApplicationInfo().sourceDir;
            PathClassLoader loader = new PathClassLoader(apkPath, pluginContext.getClassLoader());
            Class<?> clazz = loader.loadClass(Constants.PLUGIN_VIEW_CLASS_NAME);
            Constructor constructor = clazz.getConstructor(Context.class, Context.class);
            return (View) constructor.newInstance(pluginContext, hostContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        TextView text = new TextView(hostContext);
//        text.setText("yourpage");
//        text.setTextColor(Color.RED);
//        text.setTextSize(20);
//        return text;
        return null;
    }

    public static boolean isAppInstalled(){
        PackageManager pm = APP.getAppContext().getPackageManager();
        boolean installed;
        try{
            pm.getPackageInfo(Constants.PLUGIN_PACKAGE_NAME,PackageManager.GET_ACTIVITIES);
            installed =true;
        }catch(PackageManager.NameNotFoundException e){
            installed =false;
        }
        return installed;
    }
}

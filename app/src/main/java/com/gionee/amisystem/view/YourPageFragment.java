package com.gionee.amisystem.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.gionee.amisystem.R;
import com.gionee.amisystem.utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/4/12.
 */

public class YourPageFragment extends FrameLayout implements View.OnClickListener {
    private View mYourPageView;

    public YourPageFragment(@NonNull Context context) {
        super(context);

        View rootView = LayoutInflater.from(context).inflate(R.layout.fragment_yourpage, this);
        rootView.findViewById(R.id.load_yourpage).setOnClickListener(this);
//        Handler mHandler = null;
//        // 0是onPause发生的消息
//        // 1是onResume发送的消息
//
//        // onResume时,移除0
//        mHandler.removeMessages(0);
//
//        // 0是onPause发生的消息,移除1
//        mHandler.removeMessages(1);

    }

    @Override
    public void onClick(View v) {
        mYourPageView = Utils.getYourPage();
        if (mYourPageView != null) {
            removeAllViews();
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            addView(mYourPageView, lp);
        } else {
            Toast.makeText(getContext(), "load failed", Toast.LENGTH_SHORT).show();
        }
    }


    public void onYourPageResume() {
        if (mYourPageView != null) {
            callOnMethod(mYourPageView, "onYourPageResume");
        }
    }

    public void onYourPagePause() {
        if (mYourPageView != null) {
            callOnMethod(mYourPageView, "onYourPagePause");
        }
    }

    public void onYourPageRemove() {
        if (mYourPageView != null) {
            callOnMethod(mYourPageView, "onYourPageRemove");
        }
    }

    public void onYourPageSelected(boolean selected) {
        // 可以保存一个变量,连续的selected = false不必调用两次方法
        if (mYourPageView != null) {
            callOnMethod(mYourPageView, "onYourPageSelected", new Class[]{Boolean.TYPE}, selected);
        }
    }

    private void callOnMethod(Object object, String methodName) {
        callOnMethod(object, methodName, null, null);
    }

    private void callOnMethod(Object object, String methodName, Class<?>[] parameterTypes, Object... args) {
        if (object != null) {
            try {
                Method method = object.getClass().getMethod(methodName, parameterTypes);
                method.invoke(object, args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package com.gionee.amisystem.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.gionee.amisystem.R;
import com.gionee.amisystem.utils.Utils;

/**
 * Created by Administrator on 2017/4/12.
 */

public class YourPageFragment extends FrameLayout implements View.OnClickListener{
    public YourPageFragment(@NonNull Context context) {
        super(context);

        View rootView = LayoutInflater.from(context).inflate(R.layout.fragment_yourpage,this);
        rootView.findViewById(R.id.load_yourpage).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        View yourPage = Utils.getYourPage();
        if(yourPage!=null){
            removeAllViews();
            addView(yourPage);
        }else{
            Toast.makeText(getContext(), "load failed", Toast.LENGTH_SHORT).show();
        }
    }
}

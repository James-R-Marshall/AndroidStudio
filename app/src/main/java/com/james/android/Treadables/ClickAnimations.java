package com.james.android.Treadables;

import android.graphics.Color;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

import static java.lang.Thread.sleep;

public class ClickAnimations{

    public void pressed(View v) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                v.setBackgroundColor(Color.rgb(255, 255, 255));

                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                v.setBackgroundColor(Color.alpha(0));
            }
        }).start();
    }
}



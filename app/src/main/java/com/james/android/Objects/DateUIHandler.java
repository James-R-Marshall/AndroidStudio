package com.james.android.Objects;

import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import androidx.appcompat.app.AppCompatActivity;

import com.james.android.MainActivity;
import com.james.android.R;
import com.james.android.Treadables.ClickAnimations;

public class DateUIHandler implements UIHandler {

    AppCompatActivity activity;
    private CalendarView c;
    private String date;
    public DateUIHandler(AppCompatActivity activity){
        SetActivity(activity);

    }

    public void setCalendar() {
       c = (CalendarView) activity.findViewById(R.id.calendar);
    }

    @Override
    public void LinkButtonPressed(View v) {

    }
    public void setC(CalendarView cv){c = cv;}
    @Override
    public void ButtonPressed(View v) {

       date = "" + c.getDate();
       Log.d("Add", date);
    }

    @Override
    public void AnimatedButtonPressed(View v) throws InterruptedException {
        ClickAnimations cl = new ClickAnimations();
        cl.pressed(v);
    }

    @Override
    public void SetActivity(AppCompatActivity activity) {
        this.activity = activity;
    }
}

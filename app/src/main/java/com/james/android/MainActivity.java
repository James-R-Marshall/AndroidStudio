package com.james.android;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.james.android.Objects.CalendarDate;
import com.james.android.Objects.DateUIHandler;
import com.james.android.Objects.UIHandler;
import com.james.android.Repos.IRepository;

public class MainActivity extends AppCompatActivity {
    CalendarView c;
    CalendarDate date = new CalendarDate();
    UIHandler UIHandle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // grabbing the calander during the creation of out View so that we
        // can set the click handler for the calander to a custom one
        setContentView(R.layout.activity_main);
        c  = (CalendarView)findViewById(R.id.calendar);
        c.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                date.setYear(year);
                date.setDay(dayOfMonth);
                date.setMonth(month);
                String hour = ((TextView)(findViewById(R.id.Hour))).getText().toString();
                date.setHour(Integer.parseInt(hour));
                String Minute = ((TextView)(findViewById(R.id.Minute))).getText().toString();
                Log.d("Add",Minute);
                date.setMinute(Integer.parseInt(Minute));
                view.setDate(date.ConvertToMilliseconds());

            }
        });

        UIHandle = new DateUIHandler(this);
        ((DateUIHandler)UIHandle).setC(c);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void AddBtn(View v) {

        UIHandle.ButtonPressed(v);
        Toast.makeText(this, date.toString(),Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, ConfirmAddActivity.class);
        i.putExtra("date", date.toShortString());
        startActivity(i);
    }

    public void AnimatedBtn(View v) throws InterruptedException {
        UIHandle.AnimatedButtonPressed(v);
    }


}
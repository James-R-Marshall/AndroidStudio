package com.james.android;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

import com.james.android.Treadables.ClickAnimations;

public class MainActivity extends AppCompatActivity {
    CalendarView c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c  = (CalendarView)findViewById(R.id.calendar);
        c.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
            Log.d("AddBtn","year: "+ year + " Month: " + month + " Day: " + dayOfMonth);
        }
    });

    }



    public void AddBtn(View v) throws InterruptedException{

        CalendarView c = (CalendarView) findViewById(R.id.calendar);
        String date = "" + c.getDate();
        Log.d("AddBtn", date);
    }

    public void HamburgerBtn(View v) throws InterruptedException {
      //Toolbar bar = (Toolbar) findViewById(R.id.toolbar);
      //  bar.setBackgroundColor(Color.rgb(255,255,255));

        ClickAnimations cl = new ClickAnimations();
        cl.pressed(v);
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
}
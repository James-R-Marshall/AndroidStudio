package com.james.android;

import android.content.Intent;
import android.os.Bundle;

import com.james.android.Objects.CalendarDate;
import com.james.android.Repos.IRepository;
import com.james.android.Repos.TextDateRepo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;

import java.io.IOException;

public class ConfirmAddActivity extends AppCompatActivity {
CalendarDate date = new CalendarDate();
IRepository Repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_add);
        Toolbar toolbar = findViewById(R.id.toolbar2);

        setSupportActionBar(toolbar);
        Intent i = getIntent();
        String dateString = i.getStringExtra("date");
        TextView textbox = findViewById(R.id.textView4);
        date.ParseShortString(dateString);

        Repo = new TextDateRepo(this);
        try {
            Repo.ConnectRepo("Test.txt");
            setTitle("Add Date");
            textbox.setText(Repo.getContext().firstElement().toString());
            Repo.closeConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
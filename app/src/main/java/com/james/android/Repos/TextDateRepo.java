package com.james.android.Repos;

import android.content.Context;

import com.james.android.Objects.CalendarDate;
import com.james.android.Objects.RepoItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class TextDateRepo implements IRepository{
    String Name = "";
    BufferedReader br;
    Context context;
public TextDateRepo(Context ctx){
    context = ctx;
}
    @Override
    public void closeConnect() throws IOException {
    br.close();
    }

    @Override
    public Vector<CalendarDate> getContext() throws IOException {
        String line;
        Vector<CalendarDate> a = new Vector<CalendarDate>();
        CalendarDate cd;
        while ((line = br.readLine()) != null){
            cd = new CalendarDate();
            cd.ParseShortString(line);
            a.add(cd);
        }
        return a;
    }

    @Override
    public int RepoLength() {
        return 0;
    }

    @Override
    public String FindByID() {
        return null;
    }

    @Override
    public void ConnectRepo( String name) throws IOException {
    Name = name;
    InputStream is = context.getAssets().open(name);
    br = new BufferedReader(new InputStreamReader(is));
    }

    @Override
    public Vector<CalendarDate> OrderByClosest() {
        return null;
    }
}

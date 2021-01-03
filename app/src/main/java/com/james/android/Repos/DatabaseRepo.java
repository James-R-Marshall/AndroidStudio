package com.james.android.Repos;

import com.james.android.Objects.CalendarDate;

import java.io.IOException;
import java.util.Vector;

public class DatabaseRepo<t> implements IRepository{
    @Override
    public void closeConnect() throws IOException {

    }

    @Override
    public Vector<t> getContext() {
        Vector vec = new Vector<CalendarDate>();

        return (vec);
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
    public void ConnectRepo(String name) {

    }

    @Override
    public Vector<t> OrderByClosest() {
        return null;
    }
}

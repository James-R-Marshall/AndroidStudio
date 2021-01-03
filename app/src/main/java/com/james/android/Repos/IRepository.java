package com.james.android.Repos;

import com.james.android.Objects.CalendarDate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public interface IRepository<t> {
    public void closeConnect() throws IOException;
    public Vector<t> getContext() throws IOException;
    public int RepoLength();
    public String FindByID();
    public void ConnectRepo(String name) throws IOException;
    public Vector <t> OrderByClosest();

}

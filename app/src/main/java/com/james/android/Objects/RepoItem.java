package com.james.android.Objects;

import java.io.IOException;
import java.util.Vector;

public interface RepoItem<t> {
    @Override
    public String toString();
    public String toDescriptorString();
    public Vector<String> convertToListDescriptorString(Vector<CalendarDate> v);
    public void ParseShortString(String Sdate);
    public String toShortString();
}

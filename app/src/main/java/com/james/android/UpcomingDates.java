package com.james.android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.james.android.Objects.CalendarDate;
import com.james.android.Repos.IRepository;
import com.james.android.Repos.TextDateRepo;

import java.io.IOException;
import java.util.ArrayList;

public class UpcomingDates extends Fragment {
    ListView list;
    IRepository<CalendarDate> Repo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_upcoming_dates, container, false);

        list = (ListView)(RootView.findViewById(R.id.List));
        ArrayList<String> li = null;
        Repo = new TextDateRepo(getActivity());
        try {
            Repo.ConnectRepo("Test.txt");

            li = new ArrayList<String>(new CalendarDate().convertToListOFDateStrings(Repo.getContext()));
            Repo.closeConnect();
        } catch (IOException e) {
            li = new ArrayList<String>();
            e.printStackTrace();
        }
        ArrayAdapter ad = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,li);
        list.setAdapter(ad);

        return RootView;

    }
}
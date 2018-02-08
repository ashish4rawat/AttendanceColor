package com.technialrj.attendancemaster;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class YourSubjectsFragment extends Fragment {

        ArrayList<String> names ;
        RecyclerView mRecyclerView;
        RecyclerView.LayoutManager mlayoutManager;
        RecyclerView.Adapter mAdapter;
        public YourSubjectsFragment() {
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

                View view = inflater.inflate(R.layout.fragment_your_subjects, container, false);
                getActivity().setTitle("Your Subjects");

                names = new ArrayList<>();
                mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

                mRecyclerView.setHasFixedSize(true);
                mlayoutManager = new GridLayoutManager(getActivity(),2);

                mAdapter = new TTSubjectsAdapter(names);
                mRecyclerView.setLayoutManager(mlayoutManager);
                mRecyclerView.setAdapter(mAdapter);



                return view;
        }

}

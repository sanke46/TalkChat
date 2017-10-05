package com.sanke.ilafedoseev.talkchat.Fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sanke.ilafedoseev.talkchat.Adapter.RecyclerViewAdapter;
import com.sanke.ilafedoseev.talkchat.R;
import com.sanke.ilafedoseev.talkchat.User;

import java.util.ArrayList;
import java.util.List;


public class People extends Fragment {
    private List<User> users = new ArrayList<>();
    protected RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.allPeople);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(implemets(users));
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        return view;


    }

    public List<User> implemets(List<User> arr) {
        arr.add(new User("Светлов Евгений","asdfasdf12","example@gmail.com",true));
        arr.add(new User("Федосеев Илья","asdfasdf12","example@gmail.com",true));
        arr.add(new User("Анна Лазаренко","asdfasdf12","example@gmail.com",true));
        return arr;
    }

    public class chatCreat implements View.OnClickListener {
        @Override
        public void onClick(final View v) {

        }
    }

}

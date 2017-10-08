package com.sanke.ilafedoseev.talkchat.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sanke.ilafedoseev.talkchat.Adapters.ChatRecyclerViewAdapter;
import com.sanke.ilafedoseev.talkchat.Chat;
import com.sanke.ilafedoseev.talkchat.R;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    private List<Chat> chat = new ArrayList<>();
    protected RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        chat.add(new Chat("Светлов Евгений","Привет как дела?","6:09 PM"));
        chat.add(new Chat("Федосеев Илья","Это круто надо","6:09 PM"));
        chat.add(new Chat("Анна Лазаренко","ха-ха-ха-ха","6:09 PM"));

        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.allChat);
        ChatRecyclerViewAdapter adapter = new ChatRecyclerViewAdapter(chat);
        recyclerView.setAdapter(adapter);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }
}

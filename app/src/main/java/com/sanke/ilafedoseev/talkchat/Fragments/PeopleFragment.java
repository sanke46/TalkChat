package com.sanke.ilafedoseev.talkchat.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sanke.ilafedoseev.talkchat.Adapters.FriendsRecyclerViewAdapter;
import com.sanke.ilafedoseev.talkchat.DateBase.DateFriends;
import com.sanke.ilafedoseev.talkchat.Model.Friend;
import com.sanke.ilafedoseev.talkchat.R;
import com.sanke.ilafedoseev.talkchat.UI.SearchActivity;

import java.util.ArrayList;
import java.util.List;

public class PeopleFragment extends Fragment {

    public static final String DETAIL_FRIENDS_FRAGMENT = "fragment_detail_friend";
    private List<Friend> users = new ArrayList<>();
    protected RecyclerView.LayoutManager mLayoutManager;
    private DateFriends db;
    private List<Friend> list;
    private FragmentActivity myContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DateFriends(getActivity());

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
//        db.addFriend(new Friend("Светлов Евгений","example@gmail.com"));
//        db.addFriend(new Friend("Федосеев Илья","example@gmail.com"));
//        db.addFriend(new Friend("Анна Лазаренко","example@gmail.com"));

        list = db.getAllFriends();

//        for (int i = 0; i < 3; i++) {
//            System.out.println(list.get(i));
//        }

//        db.deleteAll("Su");
//        db.deleteAll("Pi");
//        db.deleteAll("Dr");
        System.out.println("DONE");
    }

    @Override
    public void onAttach(Context context) {
        myContext = (FragmentActivity) context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_people, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.allPeople);
        FriendsRecyclerViewAdapter adapter = new FriendsRecyclerViewAdapter(implemets(users), new FriendsRecyclerViewAdapter.ItemClickListener() {
            @Override
            public void onClick(int index) {
//                Toast.makeText(getActivity(), list.get(index).getName(),Toast.LENGTH_SHORT).show();
//                Toast.makeText(getActivity(), "ghbdtn", Toast.LENGTH_SHORT).show();
                DetailFriendFragment detailFriendFragment = new DetailFriendFragment();
                Bundle bundle = new Bundle();
                bundle.putString(DetailFriendFragment.KEY_DETAIL, list.get(index).getName());
                detailFriendFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = myContext.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.placeholder, detailFriendFragment, DETAIL_FRIENDS_FRAGMENT);
//                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        recyclerView.setAdapter(adapter);

        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));

        return view;
    }



    // Test init
    public List<Friend> implemets(List<Friend> arr) {
//      arr.add(new Friend("Светлов Евгений","example@gmail.com",true));
//      arr.add(new Friend("Федосеев Илья","example@gmail.com",true));
//      arr.add(new Friend("Анна Лазаренко","example@gmail.com",true));
        arr = list;

        return arr;
    }


    public void addUsers(Friend newFriend) {
        users.add(newFriend);
    }

    public List<Friend> getUsers() {
        return users;
    }
}

package com.sanke.ilafedoseev.talkchat.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sanke.ilafedoseev.talkchat.DateBase.DateFriends;
import com.sanke.ilafedoseev.talkchat.Fragments.PeopleFragment;
import com.sanke.ilafedoseev.talkchat.MainActivity;
import com.sanke.ilafedoseev.talkchat.Model.Friend;
import com.sanke.ilafedoseev.talkchat.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private DatabaseReference myRef;
    private PeopleFragment peopleFragment = new PeopleFragment();
    private FirebaseDatabase mFirebaseDatabase;
    private HashMap<String,String> usersList = new HashMap<>();
    List<String> listUser = new ArrayList<>();
    private DateFriends db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        db = new DateFriends(getApplicationContext());


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
//                    System.out.println(messageSnapshot.child("name").getValue());
                    listUser.add(messageSnapshot.child("email").getValue().toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        final EditText editText = (EditText) findViewById(R.id.findFriend);
        Button button = (Button) findViewById(R.id.button_search);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUser(listUser, editText.getText().toString());
            }
        });

    }

    public void checkUser(List<String> list, String email) {
        for (String s : list) {
            if (s.equals(email)) {
                db.deletAll();
                db.addFriend(new Friend("New Friend", s));
                startActivity(new Intent(this, MainActivity.class));
                break;
            } else {
                Toast.makeText(this, "User not exists", Toast.LENGTH_SHORT).show();
            }
        }

        seeAll();
    }

    public void seeAll() {
        for(Friend f : peopleFragment.getUsers()) {
            System.out.println(f.getName());
        }
    }



}

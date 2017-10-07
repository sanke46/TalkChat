package com.sanke.ilafedoseev.talkchat.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sanke.ilafedoseev.talkchat.R;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

//        ValueEventListener postListener = new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
//                    String email = (String) messageSnapshot.child("email").getValue();
//                    Toast.makeText(SearchActivity.this, email, Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        };
//
//        DataSnapshot
//        postListener.onDataChange();

    }

}

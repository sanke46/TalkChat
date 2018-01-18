package com.sanke.ilafedoseev.talkchat.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanke.ilafedoseev.talkchat.R;


public class DetailFriendFragment extends Fragment {

    public static final String KEY_DETAIL = "fiend_index";
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String index = getArguments().getString(KEY_DETAIL);
        textView = view.findViewById(R.id.text_name);
        textView.setText(index + "");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_friend, container, false);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}

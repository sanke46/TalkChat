package com.sanke.ilafedoseev.talkchat.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sanke.ilafedoseev.talkchat.R;
import com.sanke.ilafedoseev.talkchat.User;

import java.util.ArrayList;

/**
 * Created by ilafedoseev on 08/08/2017.
 */

public class FriendListAdapter extends ArrayAdapter<User> {

    public FriendListAdapter(@NonNull Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);
        if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_friends, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.name);
        TextView tvAvatar = (TextView) convertView.findViewById(R.id.avatar);

        tvName.setText(user.getName());
        tvAvatar.setText(constructTextAvatar(user.getName()));
        return convertView;
    }

    public String constructTextAvatar(String name) {
        String[] arrrayName;
        arrrayName = name.split(" ");
        String resultName = arrrayName[0].substring(0,1) + arrrayName[1].substring(0,1);
        return resultName;
    }


}

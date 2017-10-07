package com.sanke.ilafedoseev.talkchat.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanke.ilafedoseev.talkchat.R;
import com.sanke.ilafedoseev.talkchat.User;

import java.util.List;

/**
 * Created by ilafedoseev on 02/10/2017.
 */

public class FriendsRecyclerViewAdapter extends RecyclerView.Adapter<FriendsRecyclerViewAdapter.ViewHolder>{

    private List<User> usersFriends;
    public FriendsRecyclerViewAdapter(List<User> people) {
        this.usersFriends = people;
    }

    @Override
    public FriendsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FriendsRecyclerViewAdapter.ViewHolder holder, int position) {
        User user = usersFriends.get(position);
        holder.avatar.setText(user.getAvatarName(user.getName()));
        holder.name.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return usersFriends.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView avatar;
        private TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            avatar = (TextView) itemView.findViewById(R.id.avatar);
            name = (TextView) itemView.findViewById(R.id.name);

        }
    }
}

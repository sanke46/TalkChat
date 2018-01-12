package com.sanke.ilafedoseev.talkchat.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanke.ilafedoseev.talkchat.Model.Friend;
import com.sanke.ilafedoseev.talkchat.R;

import java.util.List;

/**
 * Created by ilafedoseev on 02/10/2017.
 */

public class FriendsRecyclerViewAdapter extends RecyclerView.Adapter<FriendsRecyclerViewAdapter.ViewHolder> {

    private List<Friend> usersFriends;

    public FriendsRecyclerViewAdapter(List<Friend> people) {
        this.usersFriends = people;
    }

    @Override
    public FriendsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview_friend, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FriendsRecyclerViewAdapter.ViewHolder holder, int position) {
        Friend user = usersFriends.get(position);
        holder.avatar.setText(user.getAvatarName(user.getName()));
        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return usersFriends.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView avatar;
        private TextView name;
        private TextView email;

        public ViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                    System.out.println(itemPosition);
                }

            });
        }
    }
}

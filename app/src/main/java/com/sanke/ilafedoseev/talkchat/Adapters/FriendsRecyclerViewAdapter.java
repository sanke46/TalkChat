package com.sanke.ilafedoseev.talkchat.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanke.ilafedoseev.talkchat.Model.Friend;
import com.sanke.ilafedoseev.talkchat.R;

import java.util.List;


public class FriendsRecyclerViewAdapter extends RecyclerView.Adapter<FriendsRecyclerViewAdapter.ViewHolder>{

    public interface ItemClickListener {
        void onClick(int index);
    }

    private List<Friend> usersFriends;
    private ItemClickListener mItemClickListener;

    public FriendsRecyclerViewAdapter(List<Friend> people, ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
        this.usersFriends = people;
    }

    @Override
    public FriendsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview_friend, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FriendsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.bindView(usersFriends.get(position), position);
    }



    @Override
    public int getItemCount() {
        return usersFriends.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int index;
        private TextView avatar;
        private TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
        }

        public void bindView(final Friend ff, int position) {
            index = position;
            avatar.setText(ff.getAvatarName(ff.getName()));
            name.setText(ff.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onClick(index);
                }
            });
        }
    }
}

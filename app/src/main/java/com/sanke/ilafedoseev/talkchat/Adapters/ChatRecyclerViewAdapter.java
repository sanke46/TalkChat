package com.sanke.ilafedoseev.talkchat.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanke.ilafedoseev.talkchat.Chat;
import com.sanke.ilafedoseev.talkchat.R;

import java.util.List;

/**
 * Created by ilafedoseev on 07/10/2017.
 */

public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.ViewHolder>{

    private List<Chat> chatWithUsers;

    public ChatRecyclerViewAdapter(List<Chat> chatWithUsers) {
        this.chatWithUsers = chatWithUsers;
    }

    @Override
    public ChatRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friends, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ChatRecyclerViewAdapter.ViewHolder holder, int position) {
        Chat chat = chatWithUsers.get(position);
        holder.avatar.setText(chat.getAvatarName(chat.getName()));
        holder.name.setText(chat.getName());
        holder.text.setText(chat.getText());
        holder.time.setText(chat.getTime());
    }

    @Override
    public int getItemCount() {
        return chatWithUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView avatar;
        private TextView name;
        private TextView text;
        private TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            avatar = (TextView) itemView.findViewById(R.id.avatarChat);
            name = (TextView) itemView.findViewById(R.id.nameChat);
            text = (TextView) itemView.findViewById(R.id.textChat);
            time = (TextView) itemView.findViewById(R.id.timeCaht);
        }
    }
}

package com.sanke.ilafedoseev.talkchat.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanke.ilafedoseev.talkchat.Model.ChatSend;
import com.sanke.ilafedoseev.talkchat.R;

import java.util.ArrayList;

/**
 * Created by ilafedoseev on 17/01/2018.
 */

public class ChatRecycleViewAdapter extends RecyclerView.Adapter<ChatRecycleViewAdapter.ViewHolder> {

    private ArrayList<ChatSend> chatList;

    public ChatRecycleViewAdapter(ArrayList<ChatSend> chatList) {
        this.chatList = chatList;
    }

    @Override
    public ChatRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_chat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatRecycleViewAdapter.ViewHolder holder, int position) {
        ChatSend chatSend = chatList.get(position);
        holder.binding(chatSend);
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text;
        private TextView time;

        public ViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.textMessage);
            time = view.findViewById(R.id.textTime);
        }

        public void binding(ChatSend chat) {
            text.setText(chat.getText());
            time.setText(chat.getTime());
        }
    }
}

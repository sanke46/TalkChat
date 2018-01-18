package com.sanke.ilafedoseev.talkchat.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sanke.ilafedoseev.talkchat.Adapters.ChatRecycleViewAdapter;
import com.sanke.ilafedoseev.talkchat.Model.ChatSend;
import com.sanke.ilafedoseev.talkchat.R;

import java.util.ArrayList;

public class ChatOpenActivity extends AppCompatActivity {

    private RecyclerView chatMessageRecycleView;
    private ChatRecycleViewAdapter adapter;
    private ArrayList<ChatSend> listMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_open);
        chatMessageRecycleView = findViewById(R.id.messageRecycle);
        listMessage = new ArrayList<>();
        listMessage.add(new ChatSend("ilya","Привет как дела ?", "12:00 AM"));
        listMessage.add(new ChatSend("vova","Хорошо спасибо ?", "13:50 AM"));
        listMessage.add(new ChatSend("ilya","Приятно слышать  ?", "21:00 AM"));
        adapter = new ChatRecycleViewAdapter(listMessage);
        chatMessageRecycleView.setAdapter(adapter);
        chatMessageRecycleView.setLayoutManager(new LinearLayoutManager(this));

        for(ChatSend ch : listMessage) {
            System.out.println(ch.getName() + " " + ch.getText() + " " + ch.getTime());
        }
    }

}

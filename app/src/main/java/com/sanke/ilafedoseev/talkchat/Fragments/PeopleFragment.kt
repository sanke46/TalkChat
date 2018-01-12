package com.sanke.ilafedoseev.talkchat.Fragments

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sanke.ilafedoseev.talkchat.Adapters.FriendsRecyclerViewAdapter
import com.sanke.ilafedoseev.talkchat.DateBase.DateFriends
import com.sanke.ilafedoseev.talkchat.Model.Friend
import com.sanke.ilafedoseev.talkchat.R
import com.sanke.ilafedoseev.talkchat.UI.ChatWithFriendsActivity
import java.util.*

class PeopleFragment : Fragment() {

    private val users = ArrayList<Friend>()
    protected lateinit var mLayoutManager: RecyclerView.LayoutManager
    private var db: DateFriends? = null
    private var list: List<Friend>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DateFriends(context)

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..")
        //        db.addFriend(new Friend("Светлов Евгений","example@gmail.com"));
        //        db.addFriend(new Friend("Федосеев Илья","example@gmail.com"));
        //        db.addFriend(new Friend("Анна Лазаренко","example@gmail.com"));

        list = db!!.allFriends

        //        for (int i = 0; i < 3; i++) {
        //            System.out.println(list.get(i));
        //        }

        //        db.deleteAll("Su");
        //        db.deleteAll("Pi");
        //        db.deleteAll("Dr");
        println("DONE")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_people, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.allPeople)
        val adapter = FriendsRecyclerViewAdapter(implemets())
        recyclerView.adapter = adapter

        mLayoutManager = LinearLayoutManager(activity) as RecyclerView.LayoutManager
        recyclerView.layoutManager = mLayoutManager

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { startActivity(Intent(activity, ChatWithFriendsActivity::class.java)) }

        recyclerView.addItemDecoration(DividerItemDecoration(activity,
                DividerItemDecoration.VERTICAL))

        return view
    }

    // Test init
    fun implemets(): List<Friend> {
        return list!!
    }

    inner class chatCreat : View.OnClickListener {
        override fun onClick(v: View) {

        }
    }

    fun addUsers(newFriend: Friend) {
        users.add(newFriend)
    }

    fun getUsers(): List<Friend> {
        return users
    }
}

package com.farshadfard.helloworldsematec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        ArrayList<PersonInfo> list = new ArrayList<>();

        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));
        list.add(new PersonInfo("Farshad", "09120766486", "Tehran, Iran"));


        RecyclerView recycler = findViewById(R.id.recycler);

        MyAdapter adapter = new MyAdapter(list);

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this, RecyclerView.VERTICAL, false));
    }
}

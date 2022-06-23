package com.example.app_note_02.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_note_02.model.Database.Diary;
import com.example.app_note_02.model.Database.DiaryDB;

import com.example.app_note_02.R;

import com.example.app_note_02.presenter.Mainpretender;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Diary> diaryList;
    private DiaryDB diaryDB = null;
    private Context mContext = null;
    private DiaryAdapter diaryAdapter;
    private RecyclerView mrecyclerView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diaryDB = DiaryDB.getInstance(this);

        mContext = getApplicationContext();

        mrecyclerView=findViewById(R.id.recyclerview);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        Mainpretender main =new Mainpretender(MainActivity.this,diaryList,diaryAdapter,mrecyclerView);

        Thread t = new Thread(main);
        t.start();


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.floatingButton(MainActivity.this,WriteActivity.class);
            }
        });
    }

}
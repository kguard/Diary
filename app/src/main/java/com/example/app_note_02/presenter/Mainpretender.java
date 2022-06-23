package com.example.app_note_02.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_note_02.model.Database.Diary;
import com.example.app_note_02.model.Database.DiaryDB;
import com.example.app_note_02.view.DiaryAdapter;
import com.example.app_note_02.view.MainActivity;

import java.util.List;

public class Mainpretender implements Contract.main{
    private Activity view;
    private List<Diary> diaryList;
    private DiaryAdapter adapter;
    private RecyclerView recyclerView;
    public Mainpretender(Activity view,List<Diary> diaryList,DiaryAdapter adapter,RecyclerView recyclerView){
        this.view= view;
        this.recyclerView=recyclerView;
        this.diaryList=diaryList;
        this.adapter=adapter;

    }
    @Override
    public void floatingButton(Context a, Class b) {
        Intent intent=new Intent(a,b);
        a.startActivity(intent);
    }

    @Override
    public void run() {
        try {
            diaryList = DiaryDB.getInstance(view).diaryDao().getAll();
            adapter = new DiaryAdapter(diaryList, view);
            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view, RecyclerView.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        catch (Exception e){}
    }
}


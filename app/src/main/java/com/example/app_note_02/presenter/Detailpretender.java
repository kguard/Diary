package com.example.app_note_02.presenter;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_note_02.model.Database.Diary;
import com.example.app_note_02.model.Database.DiaryDB;

public class Detailpretender implements Contract.detail {
    private Activity view;
    private int id;
    private EditText title;
    private EditText content;
    private int mode;
    public Detailpretender(Activity view,int id, EditText title, EditText content,int mode){
        this.view=view;
        this.id=id;
        this.title=title;
        this.content=content;
        this.mode=mode;
    }
    public void setEdit(Button del, Button edit, Button fin, EditText title, EditText content){
        del.setVisibility(View.GONE);
        edit.setVisibility(View.INVISIBLE);
        fin.setVisibility(View.VISIBLE);
        title.setEnabled(true);
        content.setEnabled(true);
    }
    public void setUnEdit(Button del, Button edit, Button fin, EditText title, EditText content){
        del.setVisibility(View.VISIBLE);
        edit.setVisibility(View.VISIBLE);
        fin.setVisibility(View.GONE);
        title.setEnabled(false);
        content.setEnabled(false);
    }
    public void setMode(int mode){
        this.mode=mode;
    }
    @Override
    public void run() {
        Diary diary = new Diary();
        diary.id = id;
        if(mode==1) {
            diary.title = title.getText().toString();
            diary.content = content.getText().toString();
            DiaryDB.getInstance(view.getApplicationContext()).diaryDao().updatediary(diary);
        }
        else if(mode==0){
            DiaryDB.getInstance(view.getApplicationContext()).diaryDao().delete(diary);
        }
    }
}

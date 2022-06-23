package com.example.app_note_02.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;

import com.example.app_note_02.model.Database.Diary;
import com.example.app_note_02.model.Database.DiaryDB;

public class Writepretender implements Contract.write{
    private Activity view;
    private EditText editText;
    private EditText editText1;
    public Writepretender(Activity view,EditText editText,EditText editText1){
        this.view=view;
        this.editText=editText;
        this.editText1=editText1;
    }

    @Override
    public void saveButton(Context a, Class b) {
        Intent intent=new Intent(a,b);
        a.startActivity(intent);
    }

    @Override
    public void run() {
        Diary diary = new Diary();
        diary.title= editText.getText().toString();
        diary.content= editText1.getText().toString();
        DiaryDB.getInstance(view.getApplicationContext()).diaryDao().insertAll(diary);
    }
}

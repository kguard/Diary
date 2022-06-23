package com.example.app_note_02.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_note_02.R;
import com.example.app_note_02.model.Database.Diary;
import com.example.app_note_02.model.Database.DiaryDB;
import com.example.app_note_02.presenter.Writepretender;


public class WriteActivity extends AppCompatActivity {

    private DiaryDB diaryDB = null;
    private EditText editText;
    private EditText editText1;
    private Button buttonSave;
    private Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        editText = findViewById(R.id.editTextTitle);
        editText1 = findViewById(R.id.editTextContent);
        buttonSave = findViewById(R.id.savebtn);
        buttonCancel = findViewById(R.id.cancelbtn);

        diaryDB = DiaryDB.getInstance(this);
        Writepretender write = new Writepretender(WriteActivity.this,editText,editText1);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread addThread = new Thread(write);
                addThread.start();
                write.saveButton(WriteActivity.this,MainActivity.class);
                finish();
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
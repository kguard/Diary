package com.example.app_note_02.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_note_02.R;
import com.example.app_note_02.model.Database.Diary;
import com.example.app_note_02.model.Database.DiaryDB;
import com.example.app_note_02.presenter.Detailpretender;
import com.example.app_note_02.view.MainActivity;

public class DetailActivity extends AppCompatActivity {

    private DiaryDB diaryDB = null;

    @Override
    public void onBackPressed() { //리사이클러뷰 갱신을 위한 함수 
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class); //지금 액티비티에서 다른 액티비티로 이동하는 인텐트 설정
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);    //인텐트 플래그 설정
        startActivity(intent);  //인텐트 이동
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent detailIntent = getIntent();
        diaryDB = DiaryDB.getInstance(this);
        int id = detailIntent.getIntExtra("id",0);
        String title = detailIntent.getStringExtra("title");
        String content = detailIntent.getStringExtra("content");
        int mode=1;

        EditText titleText = findViewById(R.id.titleEditText);
        EditText contentText = findViewById(R.id.contentEditText);
        Button delbutton = findViewById(R.id.delbutton);
        Button editbutton = findViewById(R.id.editbutton);
        Button finButton = findViewById(R.id.finbutton);

        titleText.setText(title);
        contentText.setText(content);
        Detailpretender detail=new Detailpretender(DetailActivity.this,id,titleText,contentText,mode);
        detail.setUnEdit(delbutton,editbutton,finButton,titleText,contentText);
        editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detail.setEdit(delbutton,editbutton,finButton,titleText,contentText);
            }
        });
        delbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detail.setMode(0);
                Thread delThread = new Thread(detail);
                delThread.start();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        finButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detail.setMode(1);
                Thread addThread = new Thread(detail);
                addThread.start();
                detail.setUnEdit(delbutton,editbutton,finButton,titleText,contentText);
            }
        });


    }
}
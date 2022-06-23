package com.example.app_note_02.presenter;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;


public interface Contract {
    interface main extends Runnable {
        void floatingButton(Context a, Class b);
    }
    interface write extends Runnable {
        void saveButton(Context a, Class b);
    }
    interface detail extends Runnable {
        void setEdit(Button del, Button edit, Button fin, EditText title, EditText content);
        void setUnEdit(Button del, Button edit, Button fin, EditText title, EditText content);
        void setMode(int mode);

    }
}

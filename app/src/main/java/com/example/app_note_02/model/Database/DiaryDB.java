package com.example.app_note_02.model.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Diary.class}, version = 1)
public abstract class DiaryDB extends RoomDatabase {
    private static DiaryDB INSTANCE = null;

    public abstract DiaryDao diaryDao();

    public static DiaryDB getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    DiaryDB.class, "diary.db").build();

        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}

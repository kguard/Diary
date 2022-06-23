package com.example.app_note_02.model.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DiaryDao {
    @Query("SELECT * FROM diary")
    List<Diary> getAll();

    @Insert
    void insertAll(Diary... diaries);

    @Update
    void updatediary(Diary... diaries);

    @Delete
    void delete(Diary diary);

}

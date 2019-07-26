package com.itxiaox.roomlab;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    void  insert(Word word);

    @Query("Delete from word_table")
    void deleteAll();

    @Query("select * from word_table order by word asc")
    List<Word> getAllWords();

    @Query("select * from word_table order by word asc")
    LiveData<List<Word>> getAllWords2();
}

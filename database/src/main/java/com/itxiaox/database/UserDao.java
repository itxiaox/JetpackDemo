package com.itxiaox.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("Select * from user")
    List<User> getAll();


    @Query("select * from user where uid in (:uersIds)")
    List<User> loadAllByIds(int[] uersIds);


    @Query("select * from user where first_name like:first And lastName Like :last LiMIT 1")
    User findByName(String first,String last);

    @Insert
    void insert(User user);

    @Insert
    void insertAll(User... users);

    @Delete
    void  delete(User user);
}

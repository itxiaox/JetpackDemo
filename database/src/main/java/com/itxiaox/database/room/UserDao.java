package com.itxiaox.database.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("Select * from user")
    List<User> getAll();

    @Query("select * from user where uid in (:uids)")
    List<User> loadAllByIds(int[] uids);

    @Query("select * from user where uid = :uid")
    User getUser(int uid);


    @Query("select * from user where first_name like:first And lastName Like :last LiMIT 1")
    User findByName(String first,String last);

    @Insert()
    void insert(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(User... users);

    @Delete
    void  delete(User user);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(User user);
}

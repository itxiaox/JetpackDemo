package com.itxiaox.database.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 3)
public abstract class  AppDatabase extends RoomDatabase {
    private static AppDatabase db;
    private static final String DB_NAME ="test2";
    public static void init(Context context){
        if(db==null){
            db = Room.databaseBuilder(context, AppDatabase.class,DB_NAME)
                    .build();
        }
    }

    public static AppDatabase getDatabase(){
        return db;
    }
    public abstract UserDao userDao();

}
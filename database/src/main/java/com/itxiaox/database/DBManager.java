package com.itxiaox.database;

import android.content.Context;

import androidx.room.Room;

public class DBManager {

    private static Context mConetext;

    private  static final String DB_NAME = "test.db";
    private static  AppDatabase db;

    public static void init(Context context){
          mConetext = context.getApplicationContext();
          db = Room.databaseBuilder(mConetext,AppDatabase.class,DB_NAME).build();
    }

    public static AppDatabase getAppDatabase(){
        if(db == null){
            throw new IllegalStateException("Db is not init");
        }
        return db;
    }
//    public <T> T getDao(Class<T> dao){
//
//        db.userDao().
//    }

}

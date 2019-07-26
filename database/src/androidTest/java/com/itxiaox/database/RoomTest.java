package com.itxiaox.database;

import android.content.Context;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import android.os.AsyncTask;
import android.util.Log;

import com.itxiaox.database.room.AppDatabase;
import com.itxiaox.database.room.User;
import com.itxiaox.database.room.UserDao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RoomTest {
    private static final String TAG = "RoomTest";
    AppDatabase db;
    @Before
    public void init(){
        Context context = InstrumentationRegistry.getTargetContext();
//        db = Room.databaseBuilder(context, AppDatabase.class,"test2.db").build();
        if(db==null){
            AppDatabase.init(context);
        }
        db = AppDatabase.getDatabase();
    }


    @Test
    public void testInsert(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    User user = new User();
                    user.firstName = "张";
                    user.lastName = "三";
                    user.setAge(30);
                    user.setTag("tag_test");
                    UserDao userDao =  db.userDao();
                    userDao.insert(user);
                }
            }
        }).start();


    }
    
    @Test
    public void testQueryUser(){
        UserDao userDao =  db.userDao();

        User user = userDao.getUser(0);

        Log.i(TAG, "testQueryUser: "+user!=null?user.toString():"user is null");
    }


}

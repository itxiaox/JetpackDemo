package com.itxiaox.database;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UserDaoTest {
    @Before
    public void init(){
        Context context = InstrumentationRegistry.getTargetContext();
        DBManager.init(context);
    }


    @Test
    public void testInsert(){
        User user = new User();
        user.firstName = "张";
        user.lastName = "三";
        user.setAge(30);
        user.setTag("tag_test");
        UserDao userDao =  DBManager.getAppDatabase().userDao();
        userDao.insert(user);
    }
}

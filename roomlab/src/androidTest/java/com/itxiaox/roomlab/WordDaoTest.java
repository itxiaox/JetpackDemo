package com.itxiaox.roomlab;


import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.room.testing.MigrationTestHelper;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class WordDaoTest {

    //异步查询测试规则
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private WordDao mWordDao;
    private WordRoomDatabase mDb;

    @Before
    public void createDb(){
        Context context = InstrumentationRegistry.getTargetContext();
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        //
        //创建一个内存数据库， 内存数据库仅会在进行处于活动状态时保留数据，也就是说在每次测试后，数据库都将会被清除
        mDb = Room.inMemoryDatabaseBuilder(context,WordRoomDatabase.class)
                // Allowing main thread queries, just for testing.
                .allowMainThreadQueries()
                .build();

        mWordDao =  mDb.wordDao();
    }
    @After
    public void closeDb() {
        mDb.close();
    }
    @Test
    public void insertAndGetWord() throws Exception {
        Word word = new Word("word");
        mWordDao.insert(word);
        List<Word> allWords = LiveDataTestUtil.getValue(mWordDao.getAllWords2());
        assertEquals(allWords.get(0).getWord(), word.getWord());
    }
    @Test
    public void getAllWords() throws Exception {
        Word word = new Word("aaa");
        mWordDao.insert(word);
        Word word2 = new Word("bbb");
        mWordDao.insert(word2);
        List<Word> allWords = LiveDataTestUtil.getValue(mWordDao.getAllWords2());
        assertEquals(allWords.get(0).getWord(), word.getWord());
    }

    @Test
    public void deleteAll() throws Exception {
        Word word = new Word("word");
        mWordDao.insert(word);
        Word word2 = new Word("word2");
        mWordDao.insert(word2);
        mWordDao.deleteAll();
        List<Word> allWords = LiveDataTestUtil.getValue(mWordDao.getAllWords2());
        assertTrue(allWords.isEmpty());
    }
}

package com.itxiaox.roomlab;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords2();
    }

    LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        new InsertAsyncTast(mWordDao).execute(word);
    }

    private static  class InsertAsyncTast extends AsyncTask<Word,Void,Void>{
        private WordDao mAsyncTaskDao;

        InsertAsyncTast(WordDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(Word... words) {
            mAsyncTaskDao.insert(words[0]);
            return null;
        }
    }
}

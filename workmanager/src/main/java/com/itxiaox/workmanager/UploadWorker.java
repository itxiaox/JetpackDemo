package com.itxiaox.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 测试APP杀死后，work是否还在执行
 * 结果： APP杀死后 work停止，重新启动APP后，work自动启动
 */
public class UploadWorker extends Worker {

    private static final String TAG = "UploadWorker";
    private String filePath ;
    public UploadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        filePath = context.getFilesDir().getAbsolutePath() +"/test.txt";
        Log.d(TAG, "UploadWorker: filePath="+filePath);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d(TAG, "doWork:isStopped: "+isStopped());
        while (!isStopped()){
            try {
                Thread.sleep(3000);
                String content = "doWork:"+getTime();
                Log.d(TAG, content);
                FileUtils.save(filePath,content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Result.success();
    }

    private String getTime(){
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sp.format(new Date());
    }

}

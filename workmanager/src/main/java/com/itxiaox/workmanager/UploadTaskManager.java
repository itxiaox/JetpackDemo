package com.itxiaox.workmanager;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

public class UploadTaskManager {
    private static OneTimeWorkRequest uploadRequest;
    public static LiveData<WorkInfo> startUploadTask(Context context,boolean meteredUpload) {
        //只有网络连接的时候才执行
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(meteredUpload?NetworkType.CONNECTED:NetworkType.UNMETERED)
                .build();

         uploadRequest = new OneTimeWorkRequest.Builder(UploadWorker.class)
//                .setInputData(requestData)
//                .setInitialDelay(5, TimeUnit.SECONDS)
                .setConstraints(constraints)
                .build();

        WorkManager workMgr = WorkManager.getInstance(context.getApplicationContext());
        workMgr.beginUniqueWork("test_work", ExistingWorkPolicy.KEEP, uploadRequest)
               .enqueue();
        return workMgr.getWorkInfoByIdLiveData(uploadRequest.getId());
    }

    public static void stop(Context context){
        WorkManager.getInstance(context.getApplicationContext())
                .cancelUniqueWork("test_work");
    }


}

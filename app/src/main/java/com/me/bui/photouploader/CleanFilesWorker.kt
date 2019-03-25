package com.me.bui.photouploader

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * Created by mao.bui on 3/25/2019.
 */

private const val LOG_TAG = "CleanFilesWorker"
class CleanFilesWorker(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result  = try {
        // Sleep for debugging purposes
        Thread.sleep(3000)
        Log.d(LOG_TAG, "Cleaning files!")

        ImageUtils.cleanFiles(applicationContext)

        Log.d(LOG_TAG, "Success!")
        Result.success()
    } catch (e: Throwable) {
        Log.e(LOG_TAG, "Error executing work: ${e.message}", e)
        Result.failure()
    }
}
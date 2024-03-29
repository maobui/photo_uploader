package com.me.bui.photouploader

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * Created by mao.bui on 3/25/2019.
 */

private const val LOG_TAG = "UploadWorker"
private const val KEY_ZIP_PATH = "ZIP_PATH"
class UploadWorker(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result = try {
        // Sleep for debugging purposes
        Thread.sleep(3000)
        Log.d(LOG_TAG, "Uploading file!")

        val zipPath = inputData.getString(KEY_ZIP_PATH)

        ImageUtils.uploadFile(Uri.parse(zipPath))

        Log.d(LOG_TAG, "Success!")
        Result.success()
    } catch (e: Throwable) {
        Log.e(LOG_TAG, "Error executing work: " + e.message, e)
        Result.failure()
    }
}
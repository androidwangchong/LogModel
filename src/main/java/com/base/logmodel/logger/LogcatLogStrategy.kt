package com.base.logmodel.logger

import android.util.Log

import com.base.logmodel.logger.Utils.checkNotNull


/**
 * LogCat implementation for [LogStrategy]
 *
 * This simply prints out all logs to Logcat by using standard [Log] class.
 */
class LogcatLogStrategy : LogStrategy {

    override fun log(priority: Int, tag: String?, message: String) {
        var tag = tag
        checkNotNull(message)

        if (tag == null) {
            tag = DEFAULT_TAG
        }

        Log.println(priority, tag, message)
    }

    companion object {

        internal val DEFAULT_TAG = "NO_TAG"
    }
}

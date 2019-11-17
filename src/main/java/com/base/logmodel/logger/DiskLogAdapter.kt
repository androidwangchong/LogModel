package com.base.logmodel.logger

import com.base.logmodel.logger.Utils.checkNotNull


/**
 * This is used to saves log messages to the disk.
 * By default it uses [CsvFormatStrategy] to translates text message into CSV format.
 */
open class DiskLogAdapter : LogAdapter {

    private val formatStrategy: FormatStrategy

    constructor() {
        formatStrategy = CsvFormatStrategy.newBuilder().build()
    }

    constructor(formatStrategy: FormatStrategy) {
        this.formatStrategy = checkNotNull(formatStrategy)
    }

    override fun isLoggable(priority: Int, tag: String?): Boolean {
        return true
    }

    override fun log(priority: Int, tag: String?, message: String) {
        formatStrategy.log(priority, tag, message)
    }
}

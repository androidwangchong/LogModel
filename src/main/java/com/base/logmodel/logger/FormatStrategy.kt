package com.base.logmodel.logger

/**
 * Used to determine how messages should be printed or saved.
 */
interface FormatStrategy {

    fun log(priority: Int, tag: String?, message: String)
}

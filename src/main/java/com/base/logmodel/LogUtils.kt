package com.base.logmodel

import com.base.logmodel.logger.*


class LogUtils {
    private var prettyFormatStrategy = PrettyFormatStrategy.newBuilder()
    private var csvFormatStrategy = CsvFormatStrategy.newBuilder()

    /**
     * 是否显示进程信息
     */
    fun showThreadInfo(isFormatStrategy: Boolean): LogUtils {
        prettyFormatStrategy.showThreadInfo(isFormatStrategy)
        csvFormatStrategy.showThreadInfo(isFormatStrategy)
        return this
    }

    /**
     * 要显示的方法行数。默认值2
     */
    fun methodCount(count: Int): LogUtils {
        prettyFormatStrategy.methodCount(count)
        csvFormatStrategy.methodCount(count)
        return this
    }

    /**
     * 隐藏内部方法调用到偏移量。默认值5
     */
    fun methodOffset(count: Int): LogUtils {
        prettyFormatStrategy.methodOffset(count)
        csvFormatStrategy.methodOffset(count)
        return this
    }

    /**
     * 设置LogStrategy
     */
    fun logStrategy(logStrategy: LogStrategy): LogUtils {
        prettyFormatStrategy.logStrategy(logStrategy)
        csvFormatStrategy.logStrategy(logStrategy)
        return this
    }

    /**
     * 每个日志的全局标记。默认PRETTY_LOGGER
     */
    fun tag(tag: String): LogUtils {
        prettyFormatStrategy.tag(tag)
        csvFormatStrategy.tag(tag)
        return this
    }

    /**
     * 设置日志打印输出文件夹
     * 默认 app外部存储根目录  logger文件夹
     */
    fun folderName(folderName: String): LogUtils {
        csvFormatStrategy.folderName(folderName)
        return this
    }

    /**
     * 添加打印log规则
     */
    fun addPrettyFormatStrategy() {
        Logger.addLogAdapter(object : AndroidLogAdapter(prettyFormatStrategy.build()) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
        Logger.addLogAdapter(object : DiskLogAdapter(csvFormatStrategy.build()) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }

}
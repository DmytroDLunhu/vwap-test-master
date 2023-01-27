package com.hsoft.internal;

import com.hsoft.api.VwapTriggerListener;

public class LogManager extends Logger {
    private static LogManager logManager;

    public LogManager(VwapTriggerListener vwapTriggerListener) {
        super(vwapTriggerListener);
    }

    public static Logger getLogger() {
        if (logManager == null) {
            logManager = new LogManager(vwapTriggerListener);
        }
        return logManager;
    }

    public static Logger getLogger(Class<B> bClass) {
        return getLogger();
    }
}

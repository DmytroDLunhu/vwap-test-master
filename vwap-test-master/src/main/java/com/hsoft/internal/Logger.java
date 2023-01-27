package com.hsoft.internal;

import com.hsoft.api.VwapTriggerListener;
import com.hsoft.practice.VwapTrigger;

public class Logger extends VwapTrigger {

    private static Logger logger;

    public Logger(VwapTriggerListener vwapTriggerListener) {
        super(vwapTriggerListener);
    }

    public void info(String info) {
    }
}

package com.hsoft.practice;

import org.junit.jupiter.api.Test;

import static com.hsoft.practice.VwapTrigger.vwapTriggerListener;

/**
 * One can add own unit tests here and/or in another class
 */
public class VwapTriggerTest {

    @Test
    VwapTrigger compare() throws Exception{
        VwapTrigger vwapTrigger = vwapTriggerListener {
            vwapTrigger.transactionOccurred(String.valueOf(11), 11, 11);
            vwapTrigger.fairValueChanged(String.valueOf(22), 22);
        }
        return vwapTrigger;
    }
}
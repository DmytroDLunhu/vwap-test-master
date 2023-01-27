package com.hsoft.practice;

import org.junit.jupiter.api.Test;

/**
 * One can add own unit tests here and/or in another class
 */
public class VwapTriggerTest {

    @Test
    void compare() {
        VwapTrigger vwapTrigger = new VwapTrigger();
        {
            vwapTrigger.transactionOccurred(String.valueOf(11), 11, 11);
            vwapTrigger.fairValueChanged(String.valueOf(22), 22);
        }
    }
}
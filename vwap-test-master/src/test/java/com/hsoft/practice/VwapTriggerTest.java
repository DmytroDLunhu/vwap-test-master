package com.hsoft.practice;

import com.hsoft.api.VwapTriggerListener;
import org.junit.jupiter.api.Test;

/**
 * One can add own unit tests here and/or in another class
 */
public class VwapTriggerTest {
      VwapTrigger vwapTrigger;
    @Test
    VwapTrigger compare() throws Exception {

        vwapTrigger.transactionOccurred(String.valueOf(11), 11, 11);
        vwapTrigger.fairValueChanged(String.valueOf(22), 22);
        return vwapTrigger;
    }
}
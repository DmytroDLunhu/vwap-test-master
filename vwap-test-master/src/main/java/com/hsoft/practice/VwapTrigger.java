package com.hsoft.practice;


import com.hsoft.api.MarketDataListener;
import com.hsoft.api.PricingDataListener;
import com.hsoft.api.VwapTriggerListener;

/**
 * Entry point for the candidate to resolve the exercise
 */
public class VwapTrigger implements PricingDataListener, MarketDataListener {

    public static VwapTriggerListener vwapTriggerListener = null;

    public VwapTrigger(VwapTriggerListener vwapTriggerListener) {
        this.vwapTriggerListener = vwapTriggerListener;
    }

    public VwapTrigger() {

    }

    @Override
    public VwapTrigger transactionOccurred(String productId, long quantity, double price) {
        if (this.vwapTriggerListener == vwapTriggerListener) vwapTriggerListener.notify();
        else if (this.vwapTriggerListener == null)
            return new VwapTrigger(vwapTriggerListener);
        else {
            throw new RuntimeException(vwapTriggerListener + " need to check");
        }
        return null;
        // This method will be called when a new transaction is received
        // You can then perform your check
        // And, if matching the requirement, notify the event via 'this.vwapTriggerListener.vwapTriggered(xxx);'
    }

    @Override
    public void fairValueChanged(String productId, double fairValue) {
        fairValueChanged(productId, fairValue);
        // This method will be called when a new fair value is received
        // You can then perform your check
        // And, if matching the requirement, notify the event via 'this.vwapTriggerListener.vwapTriggered(xxx);'
    }

    @Override
    public String toString() {
        return "VwapTrigger{" +
                "vwapTriggerListener=" + vwapTriggerListener +
                '}';
        // This method will be called when a new fair value is received
        // You can then perform your check
        // And, if matching the requirement, notify the event via 'this.vwapTriggerListener.vwapTriggered(xxx);'
    }

}

package com.hsoft.practice;

import com.hsoft.api.MarketDataListener;
import com.hsoft.api.PricingDataListener;
import com.hsoft.api.VwapTriggerListener;

import java.util.HashMap;


/**
 * Entry point for the candidate to resolve the exercise
 */
public class VwapTrigger extends Thread implements PricingDataListener, MarketDataListener {

    Thread thread = new Thread();

    public VwapTrigger(VwapTriggerListener vwapTriggerListener) {
        this.vwapTriggerListener = vwapTriggerListener;
    }

    public final VwapTriggerListener vwapTriggerListener;
    public static HashMap<String, Integer> transactionId = new HashMap<>();
    public static HashMap<String, Integer> productId = new HashMap<>();
    public static HashMap<String, Long> quantity = new HashMap<>();
    public static HashMap<String, Double> price = new HashMap<>();
    public static HashMap<String, Double> value = new HashMap<>();

    @Override
    public void transactionOccurred(String productId, long quantity, double price) {

        if (transactionId.containsKey(productId) && this.vwapTriggerListener == vwapTriggerListener) {
            transactionId.put(productId, 1);
            quantity.put(productId, quantity);
            price.get(productId).set(quantity);
        } else if (transactionId.get(quantity).equals(null)) {
            vwapTriggerListener.notify();
        } else if (productId.get(price).equals(null)) {
            vwapTriggerListener.notify();
        } else {
            (price.get(productId).add(price));
        }

        // This method will be called when a new transaction is received
        // You can then perform your check
        // And, if matching the requirement, notify the event via 'this.vwapTriggerListener.vwapTriggered(xxx);'
    }

    public static double formulatePrice(String productId) {
        double vwap = 0;
        for (int i = 0; i < quantity.size(); i++) {
            vwap = quantity.size(i) * price / quantity.get(i);
        }
        return vwap;
    }

    @Override
    public void fairValueChanged(String productId, double fairValue) {
        fairValueChanged(productId, fairValue);
        if ((quantity.containsKey(productId) && price.containsKey(productId))) {
            double vwapResult = formulatePrice(productId);
            if (vwapResult > fairValue) {
                vwapTriggerListener.vwapTriggered(String.valueOf(1), 1, 1);
            }
            if (value.containsKey(productId))
                value.put(productId, fairValue);
//            vwapCalculationValue(productId, fairValue);
        } else
            vwapTriggerListener.notify();

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

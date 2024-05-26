package org.example.tvmangemnet;

import org.example.tvmangemnet.Subscriber;

import java.io.Serializable;

public class Subscription implements Serializable {
    private Subscriber subscriber;
    private SubscriptionCycle cycle;
    private int numberOfTVs;
    private String date;
    private double totalFee;

    public Subscription(Subscriber subscriber, SubscriptionCycle cycle, int numberOfTVs, String date, double totalFee) {
        this.subscriber = subscriber;
        this.cycle = cycle;
        this.numberOfTVs = numberOfTVs;
        this.date = date;
        this.totalFee = totalFee;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public SubscriptionCycle getCycle() {
        return cycle;
    }

    public int getNumberOfTVs() {
        return numberOfTVs;
    }

    public String getDate() {
        return date;
    }

    public double getTotalFee() {
        return totalFee;
    }
}
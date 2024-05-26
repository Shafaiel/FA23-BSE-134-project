package org.example.tvmangemnet;

import java.io.Serializable;

public class SubscriptionCycle implements Serializable {
    private String startDate;
    private String endDate;

    public SubscriptionCycle(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}

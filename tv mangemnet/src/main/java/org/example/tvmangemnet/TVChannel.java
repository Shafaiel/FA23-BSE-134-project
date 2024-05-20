package org.example.tvmangemnet;

import java.io.Serializable;

public abstract class TVChannel implements Serializable {
    private String channelName;
    private String origin;
    private String language;
    private double price;

    public TVChannel(String channelName, String origin, String language, double price) {
        this.channelName = channelName;
        this.origin = origin;
        this.language = language;
        this.price = price;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getOrigin() {
        return origin;
    }

    public String getLanguage() {
        return language;
    }

    public double getPrice() {
        return price;
    }
}

package org.example.tvmangemnet;

import java.io.Serializable;

public class Subscriber implements Serializable {
    private String firstName;
    private String lastName;
    private String mobile;
    private String city;

    public Subscriber(String firstName, String lastName, String mobile, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getCity() {
        return city;
    }
}

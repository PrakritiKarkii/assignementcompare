package com.example.comparesocial;

import java.sql.Date;

public class Engagement {
    // Fields representing the properties of an Engagement
    private int id;
    private String platform;
    private Date date;
    private int engagementCount;

    // Constructor to initialize an Engagement object
    public Engagement(int id, String platform, Date date, int engagementCount) {
        this.id = id;
        this.platform = platform;
        this.date = date;
        this.engagementCount = engagementCount;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for platform
    public String getPlatform() {
        return platform;
    }

    // Setter for platform
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    // Getter for date
    public Date getDate() {
        return date;
    }

    // Setter for date
    public void setDate(Date date) {
        this.date = date;
    }

    // Getter for engagementCount
    public int getEngagementCount() {
        return engagementCount;
    }

    // Setter for engagementCount
    public void setEngagementCount(int engagementCount) {
        this.engagementCount = engagementCount;
    }
}

package com.khizar.year2groupproject.models;

import java.util.Date;

public class Assessment {
    private String Code;
    private String Title;
    private String Type;
    private Date Deadline;
    private String Percentage;

    public String getCode() {
        return Code;
    }
    public void setCode(String code) {
        Code = code;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getDeadline() {
        return Deadline;
    }

    public String getPercentage() {
        return Percentage;
    }

    public String getType() {
        return Type;
    }

    public void setDeadline(Date deadline) {
        Deadline = deadline;
    }

    public void setPercentage(String percentage) {
        Percentage = percentage;
    }

    public void setType(String type) {
        Type = type;
    }
}

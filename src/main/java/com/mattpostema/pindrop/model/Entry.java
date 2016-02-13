package com.mattpostema.pindrop.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Represents a complaint entry
 * Created by mpostema on 2/13/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Entry {
    private String areaCode;
    private String phoneNumber;
    private Integer numberReports;
    private String comment;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getNumberReports() {
        return numberReports;
    }

    public void setNumberReports(Integer numberReports) {
        this.numberReports = numberReports;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

package com.mattpostema.pindrop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.jsoup.nodes.Element;

/**
 * Represents a complaint entry
 * Created by mpostema on 2/13/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Complaint {
    private String areaCode;
    private String phoneNumber;
    private Integer numberReports;
    private String comment;

    public Complaint() {
    }

    public Complaint(Element element) {
        this.setAreaCode(element.getElementsByClass("wideScrOnly").get(0).child(0).text());
        this.setComment(element.getElementsByClass("oos_previewBody").text());
        this.setNumberReports(Integer.parseInt(element.getElementsByClass("postCount").text()));
        this.setPhoneNumber(element.getElementsByClass("oos_previewTitle").text());
    }

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

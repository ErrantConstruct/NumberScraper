package com.mattpostema.pindrop.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * Base response class
 * Created by mpostema on 2/13/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Response {
    protected String statusMessage;
    protected Integer statusCode;
    protected Date timeStamp;

    public Response() {
        this.timeStamp = new Date();
    }

    public Response(String statusMessage, Integer statusCode) {
        this.statusMessage = statusMessage;
        this.statusCode = statusCode;
        this.timeStamp = new Date();
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    public Date getTimeStamp() {
        return timeStamp;
    }

}

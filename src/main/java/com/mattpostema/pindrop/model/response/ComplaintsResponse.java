package com.mattpostema.pindrop.model.response;

import com.mattpostema.pindrop.model.Complaint;

import java.util.List;

/**
 * Response for a collection of phone number complaints
 * Created by mpostema on 2/13/16.
 */
public class ComplaintsResponse extends Response {
    private List<Complaint> complaints;

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }
}

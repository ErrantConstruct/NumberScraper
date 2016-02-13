package com.mattpostema.pindrop.service;

import com.mattpostema.pindrop.model.Complaint;

import java.io.IOException;
import java.util.List;

/**
 * Created by mpostema on 2/13/16.
 */
public interface ComplaintService {
    List<Complaint> getComplaints() throws IOException;

    List<Complaint> getComplaintsByAreaCode(String areaCode);
}

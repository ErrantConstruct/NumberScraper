package com.mattpostema.pindrop.rest;

import com.mattpostema.pindrop.exception.ServiceException;
import com.mattpostema.pindrop.model.Complaint;
import com.mattpostema.pindrop.model.response.ComplaintsResponse;
import com.mattpostema.pindrop.service.ComplaintService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for complaint API actions
 * Created by mpostema on 2/13/16.
 */
@RestController
@RequestMapping(value = "/complaints", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComplaintController {
    private Logger log = Logger.getLogger(ComplaintController.class);

    private static final String STATUS_MESSAGE_SUCCESS = "Success";
    private static final int STATUS_CODE_SUCCESS = 200;

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping(method = RequestMethod.GET)
    public ComplaintsResponse getAllComplaints() {
        log.info("GET request to /complaints");

        List<Complaint> complaints;
        try {
            complaints = complaintService.getComplaints();
        } catch (IOException e) {
            log.error("There was a problem retrieving complaint entries", e);
            throw new ServiceException("There was a problem retrieving complaint entries", e);
        }

        log.info("Returning " + complaints.size() + " complaints");
        return new ComplaintsResponse(STATUS_MESSAGE_SUCCESS, STATUS_CODE_SUCCESS, complaints);
    }

    @RequestMapping(value = "/{areaCode}", method = RequestMethod.GET)
    public ComplaintsResponse getComplaintsByAreaCode(@PathVariable String areaCode) {
        return new ComplaintsResponse();
    }
}

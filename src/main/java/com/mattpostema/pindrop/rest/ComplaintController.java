package com.mattpostema.pindrop.rest;

import com.mattpostema.pindrop.model.response.ComplaintsResponse;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for complaint API actions
 * Created by mpostema on 2/13/16.
 */
@RestController
@RequestMapping(value = "/complaints", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComplaintController {
    private Logger log = Logger.getLogger(ComplaintController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ComplaintsResponse getAllComplaints() {
        return new ComplaintsResponse();
    }

    @RequestMapping(value = "/{areaCode}", method = RequestMethod.GET)
    public ComplaintsResponse getComplaintsByAreaCode(@PathVariable String areaCode) {
        return new ComplaintsResponse();
    }
}

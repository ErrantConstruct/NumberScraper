package com.mattpostema.pindrop.rest;

import com.mattpostema.pindrop.model.EntriesResponse;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for entry API actions
 * Created by mpostema on 2/13/16.
 */
@RestController
@RequestMapping(value = "/entries", produces = MediaType.APPLICATION_JSON_VALUE)
public class EntryController {
    private Logger log = Logger.getLogger(EntryController.class);

    @RequestMapping(method = RequestMethod.GET)
    public EntriesResponse getAllEntries() {
        return new EntriesResponse();
    }

    @RequestMapping(value = "/{areaCode}", method = RequestMethod.GET)
    public EntriesResponse getEntriesByAreaCode(@PathVariable String areaCode) {
        return new EntriesResponse();
    }
}

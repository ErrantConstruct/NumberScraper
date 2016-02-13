package com.mattpostema.pindrop.model.response;

import com.mattpostema.pindrop.model.Entry;

import java.util.List;

/**
 * Response for a collection of phone number entries
 * Created by mpostema on 2/13/16.
 */
public class EntriesResponse extends Response {
    private List<Entry> entries;

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}

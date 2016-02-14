package com.mattpostema.pindrop.service;

import com.mattpostema.pindrop.Application;
import com.mattpostema.pindrop.model.Complaint;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for complaint scraper service
 * Created by mpostema on 2/13/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ComplaintScraperServiceTest {

    @Autowired
    private ComplaintService complaintService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetComplaints() throws Exception {
        List<Complaint> complaints = complaintService.getComplaints();
        assertNotNull(complaints);
        assertThat(complaints.size(), Matchers.greaterThan(0));
        assertThat(complaints.get(0).getAreaCode(), Matchers.notNullValue());
        assertThat(complaints.get(0).getComment(), Matchers.notNullValue());
        assertThat(complaints.get(0).getNumberReports(), Matchers.notNullValue());
        assertThat(complaints.get(0).getPhoneNumber(), Matchers.notNullValue());
    }

    @Test
    public void testGetComplaintsByAreaCode() throws Exception {

    }
}
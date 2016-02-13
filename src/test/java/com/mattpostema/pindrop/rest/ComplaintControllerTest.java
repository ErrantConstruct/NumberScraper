package com.mattpostema.pindrop.rest;

import com.mattpostema.pindrop.Application;
import com.mattpostema.pindrop.model.response.ComplaintsResponse;
import org.hamcrest.Matchers;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertThat;

/**
 * Created by mpostema on 2/13/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class ComplaintControllerTest {

    private static final String HOST = "http://localhost:8080";

    private RestTemplate template = new TestRestTemplate();

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void testGetAllComplaints() throws Exception {
        ResponseEntity<ComplaintsResponse> result = template.getForEntity(HOST + "/complaints", ComplaintsResponse.class);
        assertThat(result.getStatusCode(), Matchers.is(HttpStatus.OK));
        assertThat(result.getBody().getStatusCode(), Matchers.is(200));
        assertThat(result.getBody().getStatusMessage(), Matchers.is("Success"));
        assertThat(result.getBody().getComplaints(), Matchers.notNullValue());
    }

    @org.junit.Test
    public void testGetComplaintsByAreaCode() throws Exception {
        ResponseEntity<ComplaintsResponse> result = template.getForEntity(HOST + "/complaints/404", ComplaintsResponse.class);
        assertThat(result.getStatusCode(), Matchers.is(HttpStatus.OK));
        assertThat(result.getBody().getStatusCode(), Matchers.is(200));
        assertThat(result.getBody().getStatusMessage(), Matchers.is("Success"));
        assertThat(result.getBody().getComplaints(), Matchers.notNullValue());
    }
}
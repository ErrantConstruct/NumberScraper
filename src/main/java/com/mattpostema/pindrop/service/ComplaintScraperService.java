package com.mattpostema.pindrop.service;

import com.mattpostema.pindrop.model.Complaint;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Scrapes the 800notes site for complaint entries and converts them to the model
 * Created by mpostema on 2/13/16.
 */
@Service
public class ComplaintScraperService implements ComplaintService {

    @Value("${complaint.scraper.service.external.host:http://800notes.com}")
    private String externalSite;

    @Override
    public List<Complaint> getComplaints() throws IOException {
        //retrieve HTML from page
//        Document phoneDoc = Jsoup.connect(externalSite).get();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("local-800notes.html").getFile());
        Document phoneDoc = Jsoup.parse(file, "UTF-8", externalSite);

        //find Latest Entries list
        Element postPreviews = phoneDoc.getElementById("postPreviews");
        Elements previews = postPreviews.getElementsByClass("oos_listItem");

        //process each entry into Complaint model
        List<Complaint> complaints = new ArrayList<Complaint>();
        for (Element preview :
                previews) {
            Complaint complaint = new Complaint();
            complaint.setAreaCode(preview.getElementsByClass("wideScrOnly").get(0).child(0).text());
            complaint.setComment(preview.getElementsByClass("oos_previewBody").text());
            complaint.setNumberReports(Integer.parseInt(preview.getElementsByClass("postCount").text()));
            complaint.setPhoneNumber(preview.getElementsByClass("oos_previewTitle").text());
            complaints.add(complaint);
        }

        return complaints;
    }

    @Override
    public List<Complaint> getComplaintsByAreaCode(String areaCode) {
        return null;
    }


}

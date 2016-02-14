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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Scrapes the 800notes site for complaint entries and converts them to the model
 * Created by mpostema on 2/13/16.
 */
@Service
public class ComplaintScraperService implements ComplaintService {

    @Value("${complaint.scraper.service.external.host:http://800notes.com}")
    private String externalSite;

    @Value("${complaint.scraper.service.local:false}")
    private boolean localMode;

    @Override
    public List<Complaint> getComplaints() throws IOException {
        Elements previews = getElements();

        //process each entry into Complaint model
        List<Complaint> complaints = new ArrayList<Complaint>();
        for (Element preview : previews) {
            complaints.add(new Complaint(preview));
        }

        return complaints;
    }

    private Elements getElements() throws IOException {
        //retrieve HTML from page
        Document phoneDoc;
        if (localMode) {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("local-800notes.html").getFile());
            phoneDoc = Jsoup.parse(file, "UTF-8", externalSite);
        } else {
            phoneDoc = Jsoup.connect(externalSite).get();
        }

        //find Latest Entries list
        Element postPreviews = phoneDoc.getElementById("postPreviews");
        return postPreviews.getElementsByClass("oos_listItem");
    }

    @Override
    public List<Complaint> getComplaintsByAreaCode(String areaCode) throws IOException {
        Elements previews = getElements();

        Map<String, List<Complaint>> complaints = new HashMap<String, List<Complaint>>();
        for (Element preview : previews) {
            Complaint complaint = new Complaint(preview);

            if (complaints.containsKey(complaint.getAreaCode())) {
                complaints.get(complaint.getAreaCode()).add(complaint);
            } else {
                List<Complaint> sublist = new ArrayList<Complaint>();
                sublist.add(complaint);
                complaints.put(complaint.getAreaCode(), sublist);
            }
        }

        return complaints.get(areaCode);
    }


}

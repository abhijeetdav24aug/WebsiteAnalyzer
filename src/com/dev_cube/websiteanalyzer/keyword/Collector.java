package com.dev_cube.websiteanalyzer.keyword;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Collector implements Collectors {
    private String baseUrl;

    public Collector() {
        baseUrl = null;
    }

    public ArrayList<String> getSearchResultLinks(String keyword, int amount) {
        ArrayList<String> result = new ArrayList<>(amount);
        baseUrl = "http://www.google.de/search?q=" + keyword;
        while (result.size() < amount) {
            for (Element link : getLinkElements()) {
                if (result.size() < amount) {
                    result.add(link.attr("href"));
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public String getContentOfPage() {
        return null;
    }

    private Elements getLinkElements() {
        Elements result = null;
        try {
            Document document = Jsoup.connect(baseUrl).get();
            result = document.select(".r > a");
            baseUrl = document.selectFirst("a#pnnext").attr("abs:href");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

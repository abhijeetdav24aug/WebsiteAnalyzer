package com.dev_cube.websiteanalyzer.keyword;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Collector implements Collectors {
    private String baseUrl;
    private SearchEngine searchEngine;

    public Collector(SearchEngine searchEngine) {
        this.baseUrl = null;
        this.searchEngine = searchEngine;
    }

    public Collector() {
        this(SearchEngine.GOOGLE);
    }

    public ArrayList<String> getSearchResultLinks(String keyword, int amount) {
        ArrayList<String> result = new ArrayList<>(amount);
        baseUrl = searchEngine.getQueryUrl() + keyword;
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

    public String getContentOfPage(String url) {
        return getDocument(url).text();
    }

    private Elements getLinkElements() {
        Document document = getDocument(baseUrl);
        baseUrl = document.selectFirst(searchEngine.getCssQueryNext()).attr("abs:href");
        return document.select(searchEngine.getCssQueryResult());
    }

    private Document getDocument(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

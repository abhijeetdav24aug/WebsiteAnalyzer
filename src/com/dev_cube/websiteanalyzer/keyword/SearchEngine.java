package com.dev_cube.websiteanalyzer.keyword;

public enum SearchEngine {
    GOOGLE("http://www.google.de/search?q=", "a#pnnext", ".r > a");

    private String queryUrl;
    private String cssQueryNext;
    private String cssQueryResult;

    SearchEngine(String queryUrl, String cssQueryNext, String cssQueryResult) {
        this.queryUrl = queryUrl;
        this.cssQueryNext = cssQueryNext;
        this.cssQueryResult = cssQueryResult;
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public String getCssQueryNext() {
        return cssQueryNext;
    }

    public String getCssQueryResult() {
        return cssQueryResult;
    }
}

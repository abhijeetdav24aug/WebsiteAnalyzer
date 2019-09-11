package com.dev_cube.websiteanalyzer.keyword;

import java.util.ArrayList;

interface Collectors {
    ArrayList<String> getSearchResultLinks(String keyword, int amount);

    String getContentOfPage(String url);
}

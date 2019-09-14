package com.dev_cube.websiteanalyzer.keyword;

import java.util.Arrays;
import java.util.LinkedList;

public interface Preparator {
    default LinkedList<String> formatContent(String content) {
        content = content.toLowerCase();
        LinkedList<String> result = new LinkedList<>(Arrays.asList(content.split(("\\s"))));
        for (String word : result) {
            if (word.matches(".+\\W$")) {
                result.set(result.indexOf(word), word.substring(0, word.length() - 1));
            }
        }
        return result;
    }

    default LinkedList<String> removeBlacklistedContent(LinkedList<String> content, Blacklist blacklist) {
        content.removeAll(blacklist);
        return content;
    }
}

package org.skypro.skyshop.articles;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", title, text);
    }

    public String getSearchTerm() {
        return toString();
    }

    public String getContentName() {
        return title;
    }

    public String getContentType() {
        return "ARTICLE";
    }
}

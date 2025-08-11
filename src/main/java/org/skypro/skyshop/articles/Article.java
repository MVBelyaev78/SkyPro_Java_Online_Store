package org.skypro.skyshop.articles;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private String title;
    private String text;

    public Article(String title, String text) {
        setTitle(title);
        setText(text);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Invalid input: title of article cannot be empty");
        }
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Invalid input: text of article cannot be empty");
        }
        this.text = text;
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

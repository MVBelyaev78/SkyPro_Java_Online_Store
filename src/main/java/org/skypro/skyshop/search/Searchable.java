package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();

    String getContentName();

    String getContentType();

    default String getStringRepresentation() {
        return String.format("[%s] %s", getContentType(), getContentName());
    }
}

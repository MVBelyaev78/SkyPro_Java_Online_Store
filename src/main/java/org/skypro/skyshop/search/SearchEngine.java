package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {
    private final List<Searchable> searchList = new ArrayList<>();

    public void add(Searchable searchable) {
        searchList.add(searchable);
    }

    public List<String> search(String str) {
        return searchList
                .stream()
                .filter(s -> s.getSearchTerm().toLowerCase().contains(str.toLowerCase()))
                .map(Searchable::getStringRepresentation)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}

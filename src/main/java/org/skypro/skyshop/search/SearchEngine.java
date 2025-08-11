package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestSuitedNotFound;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SearchEngine {
    private final List<Searchable> searchList = new ArrayList<>();

    public void add(Searchable searchable) {
        searchList.add(searchable);
    }

    public List<Searchable> search(String str) {
        return searchList
                .stream()
                .filter(s -> s.getSearchTerm().toLowerCase().contains(str.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Searchable searchBestSuited(String str) throws BestSuitedNotFound {
        List<Integer> substringCountList = searchList
                .stream()
                .map(s -> s.getSearchTerm()
                        .toLowerCase()
                        .split(Pattern.quote(str.toLowerCase()), -1)
                        .length - 1)
                .toList();
        if (substringCountList.isEmpty() || 0 == substringCountList.stream().mapToInt(Integer::intValue).sum()) {
            throw new BestSuitedNotFound("Invalid data: the best suited result cannot be empty");
        }
        return searchList.get(substringCountList.indexOf(Collections.max(substringCountList)));
    }
}

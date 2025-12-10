package org.skypro.skyshop.model.search;

import org.springframework.stereotype.Service;

import java.util.UUID;

final public class SearchResult {
    private final UUID id;
    public final String name;
    public final String contentType;

    public SearchResult(UUID id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(searchable.getId(), searchable.getName(), searchable.getContent());
    }
}

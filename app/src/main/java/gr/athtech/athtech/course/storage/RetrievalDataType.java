package gr.athtech.athtech.course.storage;

import java.util.List;

import gr.athtech.athtech.course.storage.database.Movies;

public class RetrievalDataType {
    private String action;
    private List<Movies> results;

    public RetrievalDataType(String action, List<Movies> results) {
        this.action = action;
        this.results = results;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Movies> getResults() {
        return results;
    }

    public void setResults(List<Movies> results) {
        this.results = results;
    }
}

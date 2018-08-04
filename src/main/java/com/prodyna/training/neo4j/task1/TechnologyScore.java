package com.prodyna.training.neo4j.task1;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class TechnologyScore {

    private String title;

    private double score;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

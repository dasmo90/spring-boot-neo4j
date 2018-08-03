package com.prodyna.training.neo4j.task1;

import java.util.Date;
import java.util.Objects;

public class ProjectMission {

    private String projectName;

    private Date from;

    private Date to;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectMission that = (ProjectMission) o;
        return Objects.equals(projectName, that.projectName) &&
                Objects.equals(from, that.from) &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {

        return Objects.hash(projectName, from, to);
    }

    @Override
    public String toString() {
        return "ProjectMission{" +
                "projectName='" + projectName + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}

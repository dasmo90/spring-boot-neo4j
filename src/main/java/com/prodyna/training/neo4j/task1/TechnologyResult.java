package com.prodyna.training.neo4j.task1;

import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;
import java.util.Objects;

@QueryResult
public class TechnologyResult {

    private String consultantName;

    private Integer skillLvl;

    private List<ProjectMission> projects;

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }

    public Integer getSkillLvl() {
        return skillLvl;
    }

    public void setSkillLvl(Integer skillLvl) {
        this.skillLvl = skillLvl;
    }

    public List<ProjectMission> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectMission> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechnologyResult that = (TechnologyResult) o;
        return Objects.equals(consultantName, that.consultantName) &&
                Objects.equals(skillLvl, that.skillLvl) &&
                Objects.equals(projects, that.projects);
    }

    @Override
    public int hashCode() {

        return Objects.hash(consultantName, skillLvl, projects);
    }

    @Override
    public String toString() {
        return "TechnologyResult{" +
                "consultantName='" + consultantName + '\'' +
                ", skillLvl=" + skillLvl +
                ", projects=" + projects +
                '}';
    }
}

package com.prodyna.training.neo4j.task1.repository;

import com.prodyna.training.neo4j.task1.TechnologyResult;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import static com.prodyna.training.neo4j.task1.Query.TECHNOLOGY_QUERY;

@Service
public interface TechnologyRepository extends Neo4jRepository<TechnologyResult, Long> {

    @Query(TECHNOLOGY_QUERY)
    Iterable<TechnologyResult> fetchConsultantsWithTechnologySkill(@Param("technologyName") String technologyName);
}

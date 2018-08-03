package com.prodyna.training.neo4j.test;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query("match(c:Person) where c.name starts with {namePrefix} return c")
    Iterable<Person> findByNameStartingWith(@Param("namePrefix") String namePrefix);

}

package com.prodyna.training.neo4j.task1.repository;

import com.prodyna.training.neo4j.task1.TechnologyScore;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

@Service
public interface TechnologyScoreRepository extends Neo4jRepository<TechnologyScore, Long> {

    @Query("match(t:Technology) " +
            "with collect(t) as techs " +
            "call apoc.algo.pageRank(techs) yield node, score " +
            "return node.name + ' ' + node.version as title, score order by score desc")
    Iterable<TechnologyScore> fetchTechnologyScore();
}

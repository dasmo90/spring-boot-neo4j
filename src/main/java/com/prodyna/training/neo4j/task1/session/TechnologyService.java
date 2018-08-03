package com.prodyna.training.neo4j.task1.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prodyna.training.neo4j.task1.TechnologyResult;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.prodyna.training.neo4j.task1.Query.TECHNOLOGY_QUERY;

@Service
public class TechnologyService {

    private final Session session;
    private ObjectMapper objectMapper;

    public TechnologyService(Session session, ObjectMapper objectMapper) {
        this.session = session;
        this.objectMapper = objectMapper;
    }

    public Iterable<TechnologyResult> fetchConsultantsWithTechnologySkill(String technologyName) {
        Result result = this.session.query(TECHNOLOGY_QUERY,
                Collections.singletonMap("technologyName", technologyName));
        return StreamSupport.stream(result.spliterator(), true)
                .map(r -> objectMapper.convertValue(r, TechnologyResult.class))
                .collect(Collectors.toList());
    }
}

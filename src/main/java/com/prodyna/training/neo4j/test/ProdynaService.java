package com.prodyna.training.neo4j.test;

import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
public class ProdynaService {

    private static final Logger LOG = LoggerFactory.getLogger(ProdynaService.class);

    private final Session session;

    public ProdynaService(Session session) {
        this.session = session;
    }

    @PostConstruct
    public void test() {
        Iterable<Person> consultants =
                session.query(Person.class, "match(c:Person) where c.name starts with {namePrefix} return c", Collections.singletonMap("namePrefix", "K"));
        LOG.info(consultants.toString());
    }
}

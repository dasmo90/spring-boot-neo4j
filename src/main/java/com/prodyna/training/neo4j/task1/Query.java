package com.prodyna.training.neo4j.task1;

public interface Query {

    String TECHNOLOGY_QUERY =
            "match(t:Technology {name:{technologyName}})<-[:USES]-(m:Mission)<-[:WORKS_ON]-(c:Consultant), " +
                    "(m:Mission)-[:CONSISTS]->(p:Project) " +
                    "optional match(c)-[s:SKILL]->(t) " +
                    "return " +
                    "c.name as consultantName, " +
                    "collect (distinct t.version) as versions, " +
                    "collect({projectName: p.name, from:m.from, to: m.to}) as projects, " +
                    "avg(s.lvl) as skillLvl";
}

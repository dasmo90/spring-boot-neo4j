package com.prodyna.training.neo4j.task1.repository;

import com.prodyna.training.neo4j.task1.TechnologyResult;
import com.prodyna.training.neo4j.task1.TechnologyScore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task1/repository")
public class TechnologyRepositoryController {

    private final TechnologyRepository technologyRepository;
    private final TechnologyScoreRepository technologyScoreRepository;

    public TechnologyRepositoryController(TechnologyRepository technologyRepository, TechnologyScoreRepository technologyScoreRepository) {
        this.technologyRepository = technologyRepository;
        this.technologyScoreRepository = technologyScoreRepository;
    }

    @GetMapping("/consultants/technologySearch")
    public Iterable<TechnologyResult> fetchConsultantsWithTechnologySkill(
            @RequestParam("technologyName") String technologyName) {
        return this.technologyRepository.fetchConsultantsWithTechnologySkill(technologyName);
    }

    @GetMapping("/technology/score")
    public Iterable<TechnologyScore> fetchTechnologyScore() {
        return this.technologyScoreRepository.fetchTechnologyScore();
    }
}

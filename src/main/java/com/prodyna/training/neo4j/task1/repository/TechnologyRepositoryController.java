package com.prodyna.training.neo4j.task1.repository;

import com.prodyna.training.neo4j.task1.TechnologyResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task1/repository")
public class TechnologyRepositoryController {

    private final TechnologyRepository technologyRepository;

    public TechnologyRepositoryController(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @GetMapping("/consultants/technologySearch")
    public Iterable<TechnologyResult> fetchConsultantsWithTechnologySkill(
            @RequestParam("technologyName") String technologyName) {
        return this.technologyRepository.fetchConsultantsWithTechnologySkill(technologyName);
    }
}

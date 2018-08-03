package com.prodyna.training.neo4j.task1.session;

import com.prodyna.training.neo4j.task1.TechnologyResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task1/session")
public class TechnologyServiceController {

    private final TechnologyService technologyService;

    public TechnologyServiceController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/consultants/technologySearch")
    public Iterable<TechnologyResult> fetchConsultantsWithTechnologySkill(
            @RequestParam("technologyName") String technologyName) {
        return this.technologyService.fetchConsultantsWithTechnologySkill(technologyName);
    }
}

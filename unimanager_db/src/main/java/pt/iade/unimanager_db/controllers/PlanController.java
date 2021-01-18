package pt.iade.unimanager_db.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanager_db.models.Plan;
import pt.iade.unimanager_db.models.exceptions.NotFoundException;
import pt.iade.unimanager_db.models.repositories.PlanRepository;

@RestController
@RequestMapping(path = "/api/plans")
public class PlanController {
    private Logger logger = LoggerFactory.getLogger(PlanController.class);

    @Autowired
    private PlanRepository planRepository;

    @GetMapping(path = "/{courseId}/{unitId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Plan getPlanByCourseIdAndUnitId(@PathVariable int courseId, @PathVariable int unitId) {
        logger.info("Sending plan of unit by id " + unitId + " in course by id " + courseId);
        Optional<Plan> _plan = planRepository.findByCourseIdAndUnitId(courseId, unitId);

        if (_plan.isEmpty()) {
            throw new NotFoundException("" + courseId + ", " + unitId, "Study Plan", "courseId, unitId");
        } else {
            return _plan.get();
        }
    }
}

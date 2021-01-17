package pt.iade.unimanager_db.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pt.iade.unimanager_db.models.Plan;
import pt.iade.unimanager_db.models.repositories.CourseRepository;
import pt.iade.unimanager_db.models.results.SimpleResult;

public class CourseController {
    private Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping(path = "/{courseId}/units", produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleResult saveUnitInCourse(@RequestBody Plan plan) {
        logger.info("Adding unit with id " + plan.getUnit().getId());
        courseRepository.addUnitToCourse(plan);
        return new SimpleResult("Added unit with id " + plan.getUnit().getId(), plan);
    }
}

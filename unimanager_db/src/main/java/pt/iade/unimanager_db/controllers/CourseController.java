package pt.iade.unimanager_db.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanager_db.models.Course;
import pt.iade.unimanager_db.models.Plan;
import pt.iade.unimanager_db.models.exceptions.NotFoundException;
import pt.iade.unimanager_db.models.repositories.CourseRepository;
import pt.iade.unimanager_db.models.results.SimpleResult;

@RestController
@RequestMapping(path = "/api/courses")
public class CourseController {
    private Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Course> getCourses() {
        logger.info("Sending all courses");
        return courseRepository.findAll();
    }

    @PostMapping(path = "/{courseId}/units", produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleResult saveUnitInCourse(@RequestBody Plan plan) {
        logger.info("Adding unit with id " + plan.getUnit().getId());
        courseRepository.addUnitToCourse(plan);
        
        return new SimpleResult("Added unit with id " + plan.getUnit().getId(), plan);
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCourse(@PathVariable int id) {
        logger.info("Sending course by id " + id);

        Optional<Course> _course = courseRepository.findById(id);

        if (_course.isEmpty())
            throw new NotFoundException("" + id, "Course", "id");
        else
            return _course.get();
    }
}

package pt.iade.unimanager_db.controllers;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.unimanager_db.models.Enrolment;
import pt.iade.unimanager_db.models.exceptions.NotFoundException;
import pt.iade.unimanager_db.models.repositories.EnrolmentRepository;
import pt.iade.unimanager_db.models.results.SimpleResult;

@RestController
@RequestMapping(path = "/api/enrolments")
public class EnrolmentController {
    private Logger logger = LoggerFactory.getLogger(EnrolmentController.class);

    @Autowired
    private EnrolmentRepository enrolmentRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Enrolment> getStudents() {
        logger.info("Sending all enrolments");
        return enrolmentRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Enrolment getEnrolment(@PathVariable int id) {
        logger.info("Getting enrolment by id " + id);
        Optional<Enrolment> _enrolment = enrolmentRepository.findById(id);

        if (_enrolment.isEmpty())
            throw new NotFoundException("" + id, "Enrolment", "id");
        else
            return _enrolment.get();
    }

    @PutMapping(path = "/{id:[0-9]+}/grade", produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleResult setGrade(@PathVariable("id") int id, @RequestBody double grade) {
        logger.info("Setting grade of enrolment by id " + id + " for " + grade + " values");
        Optional<Enrolment> _enrolment = enrolmentRepository.findById(id);

        if (_enrolment.isEmpty()) {
            throw new NotFoundException("" + id, "Enrolment", "id");
        } else {
            Enrolment enrolment = _enrolment.get();

            enrolment.setGrade(grade);
            enrolmentRepository.save(enrolment);

            return new SimpleResult("Setting grade of enrolment by id " + id, null);
        }
    }
}

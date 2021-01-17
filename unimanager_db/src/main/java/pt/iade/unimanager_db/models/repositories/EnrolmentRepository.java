package pt.iade.unimanager_db.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.unimanager_db.models.Enrolment;

public interface EnrolmentRepository extends CrudRepository<Enrolment, Integer> {
    
}

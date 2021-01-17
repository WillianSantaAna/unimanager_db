package pt.iade.unimanager_db.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.unimanager_db.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    
}

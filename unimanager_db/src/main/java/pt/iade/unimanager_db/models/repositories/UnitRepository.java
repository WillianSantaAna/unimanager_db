package pt.iade.unimanager_db.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.unimanager_db.models.Unit;

public interface UnitRepository extends CrudRepository<Unit, Integer> {
}

package pt.iade.unimanager_db.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.unimanager_db.models.Plan;

public interface PlanRepository extends CrudRepository<Plan, Integer> {

}

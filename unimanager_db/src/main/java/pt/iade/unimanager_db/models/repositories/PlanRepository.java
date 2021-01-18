package pt.iade.unimanager_db.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.unimanager_db.models.Plan;

public interface PlanRepository extends CrudRepository<Plan, Integer> {
    Optional<Plan> findByCourseIdAndUnitId(int courseId, int unitId);
}

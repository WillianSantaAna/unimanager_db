package pt.iade.unimanager_db.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.unimanager_db.models.Unit;
import pt.iade.unimanager_db.models.views.UnitPlanView;

public interface UnitRepository extends CrudRepository<Unit, Integer> {
    Iterable<Unit> findByName(String name);

    Iterable<Unit> findByNameContaining(String name);

    Iterable<Unit> findByCreditsBetween(int min, int max);

    Iterable<Unit> findByNameContainingAndCreditsBetween(String name, int min, int max);

    String QueryFindUnitPlans = "SELECT u.dis_id AS id, u.dis_nome AS name, u.dis_creditos AS credits, "
            + "p.pla_semestre AS semester,  c.cur_nome AS courseName, c.cur_id AS courseId " + "FROM disciplinas u "
            + "INNER JOIN planoestudos p ON u.dis_id = p.pla_dis_id "
            + "INNER JOIN cursos c ON p.pla_cur_id = c.cur_id";

    @Query(value = QueryFindUnitPlans, nativeQuery = true)
    Iterable<UnitPlanView> findAllUnitPlans();

    @Query(value = QueryFindUnitPlans + " Where u.dis_id = :id", nativeQuery = true)
    Iterable<UnitPlanView> findUnitPlansById(@Param("id") int id);

    @Query(value = QueryFindUnitPlans + " Where u.dis_id = :idUnit and c.cur_id = :idCourse", nativeQuery = true)
    Optional<UnitPlanView> findUnitPlanByUnitAndCourse(@Param("idUnit") int idUnit, @Param("idCourse") int idCourse);

}

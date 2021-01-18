package pt.iade.unimanager_db.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pt.iade.unimanager_db.models.ids.PlanId;

@Entity
@Table(name = "planoestudos")
@IdClass(PlanId.class)
public class Plan {
    @Id
    @Column(name = "pla_cur_id")
    @JsonIgnore
    private int courseId;

    @Id
    @Column(name = "pla_dis_id")
    @JsonIgnore
    private int unitId;

    @Column(name = "pla_semestre")
    private int semester;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "pla_cur_id")
    @JsonIgnoreProperties("plans")
    private Course course;

    @ManyToOne
    @MapsId("unitId")
    @JoinColumn(name = "pla_dis_id")
    @JsonIgnoreProperties("plans")
    private Unit unit;

    @OneToMany
    @JoinColumns({ @JoinColumn(name = "ins_pla_cur_id"), @JoinColumn(name = "ins_pla_dis_id") })
    @JsonIgnoreProperties("plan")
    private List<Enrolment> enrolments = new ArrayList<>();

    public Plan() {
    }

    public Plan(int courseId, Course course, int semester, int unitId, Unit unit) {
        this.courseId = courseId;
        this.course = course;
        this.semester = semester;
        this.unitId = unitId;
        this.unit = unit;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getUnitId() {
        return unitId;
    }

    public int getSemester() {
        return semester;
    }

    public Course getCourse() {
        return course;
    }

    public Unit getUnit() {
        return unit;
    }

    public List<Enrolment> getEnrolments() {
        return enrolments;
    }
}

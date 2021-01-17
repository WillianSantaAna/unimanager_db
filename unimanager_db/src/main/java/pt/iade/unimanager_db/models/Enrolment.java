package pt.iade.unimanager_db.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "inscricoes")
public class Enrolment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ins_id")
    private int id;

    @Column(name = "ins_dt_inscricao")
    private LocalDate enrolmentDate;
    
    @Column(name = "ins_dt_avaliacao")
    private LocalDate examDate;
    
    @Column(name = "ins_nota")
    private double grade;

    @ManyToOne
    @JoinColumn(name = "ins_alu_id")
    private Student student;

    @ManyToOne
    @JoinColumns({ @JoinColumn(name = "ins_pla_cur_id"), @JoinColumn(name = "ins_pla_dis_id") })
    @JsonIgnoreProperties("enrolments")
    private Plan plan;

    public Enrolment() {
    }

    public Enrolment(int id, LocalDate enrolmentDate, LocalDate examDate, double grade, Student student, Plan plan) {
        this.id = id;
        this.enrolmentDate = enrolmentDate;
        this.examDate = examDate;
        this.grade = grade;
        this.student = student;
        this.plan = plan;
    }

    public int getId() {
        return id;
    }

    public LocalDate getEnrolmentDate() {
        return enrolmentDate;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public double getGrade() {
        return grade;
    }

    public Student getStudent() {
        return student;
    }

    public Plan getPlan() {
        return plan;
    }
}

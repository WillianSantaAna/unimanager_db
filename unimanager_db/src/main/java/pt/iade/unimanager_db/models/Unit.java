package pt.iade.unimanager_db.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "disciplinas")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dis_id")
    private int id;

    @Column(name = "dis_nome")
    private String name;

    @Column(name = "dis_creditos")
    private int credits;

    @OneToMany
    @JoinColumn(name = "pla_dis_id")
    @JsonIgnoreProperties("unit")
    private List<Plan> plans;

    @ManyToOne
    @JoinColumn(name = "dis_dep_id")
    private Department department;

    public Unit() {
    }

    public Unit(int id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public Department getDepartment() {
        return department;
    }
}

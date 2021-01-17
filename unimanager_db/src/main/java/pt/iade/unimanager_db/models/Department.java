package pt.iade.unimanager_db.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departamentos")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dep_id")
    private int id;

    @Column(name = "dep_nome")
    private String name;
    
    @Column(name = "dep_sigla")
    private char acronyms;

    public Department() {
    }

    public Department(int id, String name, char acronyms) {
        this.id = id;
        this.name = name;
        this.acronyms = acronyms;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getAcronyms() {
        return acronyms;
    }
}

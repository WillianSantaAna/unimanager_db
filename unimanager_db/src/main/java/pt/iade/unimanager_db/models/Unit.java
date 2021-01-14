package pt.iade.unimanager_db.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disciplinas")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dis_id;
    private String dis_nome;
    private int dis_creditos;

    public Unit() {
    }

    public Unit(int dis_id, String dis_nome, int dis_creditos) {
        this.dis_id = dis_id;
        this.dis_nome = dis_nome;
        this.dis_creditos = dis_creditos;
    }

    public int getDis_id() {
        return dis_id;
    }

    public String getDis_nome() {
        return dis_nome;
    }

    public int getDis_creditos() {
        return dis_creditos;
    }
}

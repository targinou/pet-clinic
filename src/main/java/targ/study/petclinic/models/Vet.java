package targ.study.petclinic.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Vet extends Pessoa{

    private String registro;

    @ManyToOne
    @JoinColumn(name = "consulta_ID")
    private Consulta consulta;

}

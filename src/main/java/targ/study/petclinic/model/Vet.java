package targ.study.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Vet extends Pessoa{

    @NotBlank
    @NotNull
    private String identificador;

    @ManyToOne
    @JoinColumn(name = "consulta_ID")
    private Consulta consulta;

}

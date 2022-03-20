package targ.study.petclinic.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotNull
    @NotBlank
    private String nome;

    private LocalDate aniversario;

    @ManyToOne
    @JoinColumn(name = "consulta_ID")
    private Consulta consulta;

}

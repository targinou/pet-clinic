package targ.study.petclinic.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;


    private String nome;

    private LocalDate aniversario;

    @ManyToOne
    @JoinColumn(name = "consulta_ID")
    private Consulta consulta;


}

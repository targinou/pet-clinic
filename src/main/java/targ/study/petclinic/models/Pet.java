package targ.study.petclinic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String nome;
    private LocalDate aniversario;

    @ManyToOne
    @JsonIgnore
    private Dono dono;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private List<Consulta> consultas;

}

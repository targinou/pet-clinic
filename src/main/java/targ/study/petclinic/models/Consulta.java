package targ.study.petclinic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate data;

    private String status;

    @ManyToOne
    @JsonIgnore
    private Pet pet;

    @ManyToOne
    @JsonIgnore
    private Vet vet;

}

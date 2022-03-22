package targ.study.petclinic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Dono dono;

    @ManyToOne
    @JoinColumn(name = "consulta_ID")
    private Consulta consulta;

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }
}

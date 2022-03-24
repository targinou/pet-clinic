package targ.study.petclinic.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Vet extends Pessoa{

    private String registro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vet")
    private List<Consulta> consultas;

}

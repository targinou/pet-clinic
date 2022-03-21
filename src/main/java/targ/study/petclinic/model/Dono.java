package targ.study.petclinic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Dono extends Pessoa{
    private String telefone;
    private String endereco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dono")
    private List<Pet> pets;


}

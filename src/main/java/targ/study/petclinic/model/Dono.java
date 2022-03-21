package targ.study.petclinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Data
public class Dono extends Pessoa{
    private String telefone;
    private String endereco;


    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;


}

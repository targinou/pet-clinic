package targ.study.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
public class Dono extends Pessoa{
    private String telefone;
    private String endereco;


    public Dono() {
    }

    public Dono(String telefone, String endereco, Pet pet) {
        this.telefone = telefone;
        this.endereco = endereco;
        this.pet = pet;
    }

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}

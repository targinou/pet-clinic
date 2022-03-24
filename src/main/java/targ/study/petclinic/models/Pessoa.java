package targ.study.petclinic.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String nome;
    private String email;

}

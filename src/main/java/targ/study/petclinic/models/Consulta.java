package targ.study.petclinic.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private Boolean status;

}

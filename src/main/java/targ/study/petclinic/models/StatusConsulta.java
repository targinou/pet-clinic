package targ.study.petclinic.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum StatusConsulta {
    EmAnalise("Em analise"),
    Confirmado("Confirmado"),
    Rejeitado("Rejeitado");

    private final String descricao;


    StatusConsulta(String descricao) {
        this.descricao = descricao;
    }


}


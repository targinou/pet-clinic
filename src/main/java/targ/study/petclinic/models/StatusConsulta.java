package targ.study.petclinic.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusConsulta {
    EmAnalise("Em analise"),
    Confirmado("Confirmado"),
    Rejeitado("Rejeitado");

    private final String codigo;
    private final String descricao;


    StatusConsulta(String descricao) {
        this.codigo = this.name();
        this.descricao = descricao;
    }

    @JsonCreator
    public static StatusConsulta deserializar(@JsonProperty("codigo") String codigo){
        return StatusConsulta.valueOf(codigo);
    }

    public static StatusConsulta fromString(String from){
        for (StatusConsulta statusConsulta: StatusConsulta.values()){
           if(statusConsulta.descricao.equals(from)){
               return statusConsulta;
           }
        }
        return null;
    }
}


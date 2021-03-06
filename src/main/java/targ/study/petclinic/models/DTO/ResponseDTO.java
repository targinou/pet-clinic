package targ.study.petclinic.models.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ResponseDTO<T> {
    private Integer status;
    private List<String> messages;
    private T responseObject;
}


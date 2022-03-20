package targ.study.petclinic.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ResponseStatus()
public class BadRequestExeption extends RuntimeException{

    public BadRequestExeption(String message) {
        super(message);
    }

}

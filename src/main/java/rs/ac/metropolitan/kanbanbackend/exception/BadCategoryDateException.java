package rs.ac.metropolitan.kanbanbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Početak kategorije mora biti pre kraja.")
public class BadCategoryDateException extends RuntimeException {

    public BadCategoryDateException() {
    }

}

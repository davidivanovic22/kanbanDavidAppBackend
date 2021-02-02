package rs.ac.metropolitan.kanbanbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoryAlreadyExistsException extends RuntimeException {

    public CategoryAlreadyExistsException() {
    }

    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
}

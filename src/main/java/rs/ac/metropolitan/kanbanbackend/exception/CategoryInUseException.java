package rs.ac.metropolitan.kanbanbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Ne možete obrisati aktivnu kategoriju")
public class CategoryInUseException extends RuntimeException {

    public CategoryInUseException() {
    }

}

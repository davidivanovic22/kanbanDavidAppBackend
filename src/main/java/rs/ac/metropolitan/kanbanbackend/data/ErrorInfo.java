package rs.ac.metropolitan.kanbanbackend.data;

import lombok.Data;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

@Data
public class ErrorInfo {
    private String message;
    private int code;
    private String error;
    private String url;

    public ErrorInfo(HttpServletRequest request, Throwable ex, HttpStatus status) {
        String msg = ex.getMessage();
        message = msg == null || msg.isEmpty() ? status.getReasonPhrase() : msg;
        code = status.value();
        error = status.getReasonPhrase();
        url = request.getRequestURI();
    }
}

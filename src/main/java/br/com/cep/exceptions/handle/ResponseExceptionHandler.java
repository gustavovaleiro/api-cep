package br.com.cep.exceptions.handle;

import br.com.cep.exceptions.BadRequest;
import br.com.cep.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<StandardError> objectNotFound(BadRequest ex, HttpServletRequest request)
    {
        StandardError error = StandardError.builder()
                .message(ex.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timeStamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request)
    {
        StandardError error = StandardError.builder()
                .message(ex.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timeStamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}

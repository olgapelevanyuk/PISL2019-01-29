package lab6.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ResponseEntity handleValidationErrors(MethodArgumentNotValidException exception) {
        List<String> errors = new ArrayList<>();

        exception.getBindingResult()
            .getFieldErrors()
            .forEach(
                f -> errors.add(f.getDefaultMessage())
            );

        errors.sort(String::compareTo);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

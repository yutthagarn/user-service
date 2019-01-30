package com.example.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: Cyl3erPunKz
 * Date: 30 January 2019
 * Time: 16:19
 **/
@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, Object> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("type", "validation");
        error.put("violations", extractError(ex));
        return error;
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, Object> handleValidation(BindException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("type", "validation");
        error.put("violations", extractError(ex));
        return error;
    }

    private Map<String, ValidationErrorMessage> extractError(MethodArgumentNotValidException ex) {
        Map<String, ValidationErrorMessage> errorMessageMap = new HashMap<>();
        for (ObjectError e : ex.getBindingResult().getAllErrors()) {
            if (e instanceof FieldError) {
                errorMessageMap.put(((FieldError) e).getField(), new ValidationErrorMessage((FieldError) e));
            }
            if (e instanceof ObjectError) {
                errorMessageMap.put(e.getCodes()[0], new ValidationErrorMessage(e));
            }
        }
        return errorMessageMap;
    }

    private Map<String, ValidationErrorMessage> extractError(BindException ex) {
        return ex.getBindingResult().getAllErrors().stream()
                .filter(e -> e instanceof FieldError)
                .map(e -> (FieldError) e)
                .collect(Collectors.toMap(FieldError::getField, ValidationErrorMessage::new));
    }


    public static class ValidationErrorMessage {

        private String message;

        private String type;

        public ValidationErrorMessage(FieldError fieldError) {
            this.message = fieldError.getDefaultMessage();
            this.type = fieldError.getObjectName();
        }

        public ValidationErrorMessage(ObjectError objectError) {
            this.message = objectError.getDefaultMessage();
            this.type = objectError.getObjectName();
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }


}

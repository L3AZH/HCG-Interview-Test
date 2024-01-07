package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.exception;

import com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.dto.base.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class InventoryExceptionHandler {
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .flag(false)
                .errorMessage(e.getMessage()).build(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

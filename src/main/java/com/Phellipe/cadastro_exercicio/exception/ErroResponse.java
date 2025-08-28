package com.Phellipe.cadastro_exercicio.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErroResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
}

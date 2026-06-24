package com.jar.SIGED.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {

    private int codigo;
    private String mensaje;
    private String detalle;
}
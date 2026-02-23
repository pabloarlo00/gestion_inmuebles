package com.inspecciones.gestion_inmuebles.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return generarRespuesta(HttpStatus.NOT_FOUND, "Recurso no encontrado", exception.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        String detail = exception.getMostSpecificCause().getMessage();
        String mensajeUsuario = "Error de integridad de datos.";

        if (detail.contains("dni")) {
            mensajeUsuario = "El DNI introducido ya existe en el sistema.";
        } else if (detail.contains("email")) {
            mensajeUsuario = "El correo electrónico ya está registrado.";
        } else if (detail.contains("numero_colegiado") || detail.contains("numeroColegiado")) {
            mensajeUsuario = "El número de colegiado ya está asignado a otro inspector.";
        }

        return generarRespuesta(HttpStatus.BAD_REQUEST, mensajeUsuario, detail);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception exception) {
        return generarRespuesta(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor", exception.getMessage());
    }

    private ResponseEntity<Object> generarRespuesta(HttpStatus status, String mensaje, String errorTecnico) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("estado", status.value());
        body.put("mensaje", mensaje);
        body.put("codigo_error", status.getReasonPhrase());
        body.put("detalle_tecnico", errorTecnico);

        return new ResponseEntity<>(body, status);
    }
}
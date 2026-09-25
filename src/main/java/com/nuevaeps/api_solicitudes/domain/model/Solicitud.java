package com.nuevaeps.api_solicitudes.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {
    private Integer idSolicitud;
    private Integer idUsuario;
    private Medicamento medicamento;
    private Integer cantidad;
    private String estado;
    private LocalDateTime fechaSolicitud;
    private String numeroOrden;
    private String direccion;
    private String telefono;
    private String correoElectronico;
}

package com.nuevaeps.api_solicitudes.domain.port.in;

import com.nuevaeps.api_solicitudes.domain.model.PaginacionResponse;
import com.nuevaeps.api_solicitudes.domain.model.Solicitud;

import java.util.List;

public interface SolicitudUseCase {
    Solicitud crearSolicitud(Solicitud solicitud);
    PaginacionResponse<Solicitud> listarSolicitudes(int page, int size);
}

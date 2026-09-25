package com.nuevaeps.api_solicitudes.domain.port.out;

import com.nuevaeps.api_solicitudes.domain.model.Solicitud;

import java.util.List;

public interface SolicitudRepositoryPort {
    Solicitud guardar(Solicitud solicitud);
    List<Solicitud> obtenerTodasPaginadas(int page, int size);
    long contarTotalSolicitudes();
}

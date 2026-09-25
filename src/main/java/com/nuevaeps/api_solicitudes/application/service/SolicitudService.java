package com.nuevaeps.api_solicitudes.application.service;

import com.nuevaeps.api_solicitudes.domain.model.PaginacionResponse;
import com.nuevaeps.api_solicitudes.domain.model.Solicitud;
import com.nuevaeps.api_solicitudes.domain.port.in.SolicitudUseCase;
import com.nuevaeps.api_solicitudes.domain.port.out.SolicitudRepositoryPort;

import java.util.List;

public class SolicitudService implements SolicitudUseCase {
    private final SolicitudRepositoryPort repositoryPort;

    public SolicitudService(SolicitudRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Solicitud crearSolicitud(Solicitud solicitud) {
        solicitud.setEstado("Pendiente");
        return repositoryPort.guardar(solicitud);
    }

    @Override
    public PaginacionResponse<Solicitud> listarSolicitudes(int page, int size) {
        List<Solicitud> lista = repositoryPort.obtenerTodasPaginadas(page, size);
        long total = repositoryPort.contarTotalSolicitudes();
        return new PaginacionResponse<>(lista, page, size, total);
    }
}

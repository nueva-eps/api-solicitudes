package com.nuevaeps.api_solicitudes.infrastructure.adapter.out.persistence;

import com.nuevaeps.api_solicitudes.domain.model.Medicamento;
import com.nuevaeps.api_solicitudes.domain.model.Solicitud;
import com.nuevaeps.api_solicitudes.domain.port.out.MedicamentoRepositoryPort;
import com.nuevaeps.api_solicitudes.domain.port.out.SolicitudRepositoryPort;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiciosPersistenceAdapter implements MedicamentoRepositoryPort, SolicitudRepositoryPort {

    private final MedicamentoRepository medicamentoRepository;
    private final SolicitudRepository solicitudRepository;
    private final EntityManager entityManager;

    public ServiciosPersistenceAdapter(MedicamentoRepository medicamentoRepository,
                                       SolicitudRepository solicitudRepository,
                                       EntityManager entityManager) {
        this.medicamentoRepository = medicamentoRepository;
        this.solicitudRepository = solicitudRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Medicamento> obtenerTodos() {
        return medicamentoRepository.findAll().stream()
                .map(this::mapToMedicamentoDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Solicitud guardar(Solicitud solicitud) {
        SolicitudEntity entity = new SolicitudEntity();
        entity.setIdUsuario(solicitud.getIdUsuario());
        entity.setCantidad(solicitud.getCantidad());
        entity.setEstado(solicitud.getEstado());
        entity.setNumeroOrden(solicitud.getNumeroOrden());
        entity.setDireccion(solicitud.getDireccion());
        entity.setTelefono(solicitud.getTelefono());
        entity.setCorreoElectronico(solicitud.getCorreoElectronico());

        MedicamentoEntity medEntity = entityManager.getReference(MedicamentoEntity.class, solicitud.getMedicamento().getIdMedicamento());
        entity.setMedicamento(medEntity);

        SolicitudEntity guardada = solicitudRepository.save(entity);
        return mapToSolicitudDomain(guardada);
    }

    @Override
    public List<Solicitud> obtenerTodasPaginadas(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return solicitudRepository.findAll(pageable).stream()
                .map(this::mapToSolicitudDomain)
                .collect(Collectors.toList());
    }

    @Override
    public long contarTotalSolicitudes() {
        return solicitudRepository.count();
    }

    private Medicamento mapToMedicamentoDomain(MedicamentoEntity entity) {
        return new Medicamento(entity.getIdMedicamento(), entity.getNombre(), entity.getPresentacion(), entity.getEsPos());
    }

    private Solicitud mapToSolicitudDomain(SolicitudEntity entity) {
        return new Solicitud(
                entity.getIdSolicitud(),
                entity.getIdUsuario(),
                mapToMedicamentoDomain(entity.getMedicamento()),
                entity.getCantidad(),
                entity.getEstado(),
                entity.getFechaSolicitud(),
                entity.getNumeroOrden(),
                entity.getDireccion(),
                entity.getTelefono(),
                entity.getCorreoElectronico()
        );
    }
}
package com.nuevaeps.api_solicitudes.application.service;

import com.nuevaeps.api_solicitudes.domain.model.Medicamento;
import com.nuevaeps.api_solicitudes.domain.port.in.MedicamentoUseCase;
import com.nuevaeps.api_solicitudes.domain.port.out.MedicamentoRepositoryPort;

import java.util.List;

public class MedicamentoService implements MedicamentoUseCase {
    private final MedicamentoRepositoryPort repositoryPort;

    public MedicamentoService(MedicamentoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Medicamento> listarMedicamentos() {
        return repositoryPort.obtenerTodos();
    }
}

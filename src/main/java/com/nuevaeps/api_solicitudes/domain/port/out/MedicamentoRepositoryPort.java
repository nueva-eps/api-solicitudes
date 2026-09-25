package com.nuevaeps.api_solicitudes.domain.port.out;

import com.nuevaeps.api_solicitudes.domain.model.Medicamento;

import java.util.List;

public interface MedicamentoRepositoryPort {
    List<Medicamento> obtenerTodos();
}

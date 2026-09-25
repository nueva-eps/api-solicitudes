package com.nuevaeps.api_solicitudes.domain.port.in;

import com.nuevaeps.api_solicitudes.domain.model.Medicamento;

import java.util.List;

public interface MedicamentoUseCase {
    List<Medicamento> listarMedicamentos();
}

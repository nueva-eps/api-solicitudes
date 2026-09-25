package com.nuevaeps.api_solicitudes.infrastructure.adapter.in.web;

import com.nuevaeps.api_solicitudes.domain.model.Medicamento;
import com.nuevaeps.api_solicitudes.domain.port.in.MedicamentoUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {
    private final MedicamentoUseCase useCase;

    public MedicamentoController(MedicamentoUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Medicamento>> list() {
        return ResponseEntity.ok(useCase.listarMedicamentos());
    }
}

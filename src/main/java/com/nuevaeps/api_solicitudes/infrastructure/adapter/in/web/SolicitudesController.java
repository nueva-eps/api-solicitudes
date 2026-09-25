package com.nuevaeps.api_solicitudes.infrastructure.adapter.in.web;

import com.nuevaeps.api_solicitudes.domain.model.Medicamento;
import com.nuevaeps.api_solicitudes.domain.model.PaginacionResponse;
import com.nuevaeps.api_solicitudes.domain.model.Solicitud;
import com.nuevaeps.api_solicitudes.domain.port.in.SolicitudUseCase;
import com.nuevaeps.api_solicitudes.infrastructure.adapter.in.web.dto.CreateSolicitudRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudesController {
    private final SolicitudUseCase useCase;

    public SolicitudesController(SolicitudUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/create")
    public ResponseEntity<Solicitud> create(@RequestBody CreateSolicitudRequest request) {
        Solicitud solicitud = useCase.crearSolicitud(request.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitud);
    }

    @GetMapping("/list")
    public ResponseEntity<PaginacionResponse<Solicitud>> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(useCase.listarSolicitudes(page, size));
    }
}

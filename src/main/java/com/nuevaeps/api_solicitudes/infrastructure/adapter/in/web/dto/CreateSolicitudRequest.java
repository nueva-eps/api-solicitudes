package com.nuevaeps.api_solicitudes.infrastructure.adapter.in.web.dto;

import com.nuevaeps.api_solicitudes.domain.model.Medicamento;
import com.nuevaeps.api_solicitudes.domain.model.Solicitud;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateSolicitudRequest {
    private Integer idUsuario;
    private Integer idMedicamento;
    private Integer cantidad;
    private String numeroOrden;
    private String direccion;
    private String telefono;
    private String correoElectronico;

    public Solicitud toDomain() {
        Solicitud solicitud = new Solicitud();
        solicitud.setIdUsuario(this.idUsuario);
        solicitud.setCantidad(this.cantidad);
        solicitud.setNumeroOrden(this.numeroOrden);
        solicitud.setDireccion(this.direccion);
        solicitud.setTelefono(this.telefono);
        solicitud.setCorreoElectronico(this.correoElectronico);
        Medicamento med = new Medicamento();
        med.setIdMedicamento(this.idMedicamento);
        solicitud.setMedicamento(med);

        return solicitud;
    }
}

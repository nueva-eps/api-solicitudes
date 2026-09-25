package com.nuevaeps.api_solicitudes.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {
    private Integer idMedicamento;
    private String nombre;
    private String presentacion;
    private Boolean esPos;
}

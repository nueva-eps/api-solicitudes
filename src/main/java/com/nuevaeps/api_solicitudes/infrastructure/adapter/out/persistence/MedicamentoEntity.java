package com.nuevaeps.api_solicitudes.infrastructure.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medicamentos", schema = "catalogo")
public class MedicamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicamento")
    private Integer idMedicamento;
    private String nombre;
    private String presentacion;
    @Column(name = "es_pos")
    private Boolean esPos;
}
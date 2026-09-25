package com.nuevaeps.api_solicitudes.infrastructure.config;

import com.nuevaeps.api_solicitudes.application.service.MedicamentoService;
import com.nuevaeps.api_solicitudes.application.service.SolicitudService;
import com.nuevaeps.api_solicitudes.domain.port.in.MedicamentoUseCase;
import com.nuevaeps.api_solicitudes.domain.port.in.SolicitudUseCase;
import com.nuevaeps.api_solicitudes.domain.port.out.MedicamentoRepositoryPort;
import com.nuevaeps.api_solicitudes.domain.port.out.SolicitudRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public MedicamentoUseCase medicamentoUseCase(MedicamentoRepositoryPort medicamentoRepositoryPort) {
        return new MedicamentoService(medicamentoRepositoryPort);
    }

    @Bean
    public SolicitudUseCase solicitudUseCase(SolicitudRepositoryPort solicitudRepositoryPort) {
        return new SolicitudService(solicitudRepositoryPort);
    }
}

package com.pey.rengoku;

import com.microsoft.applicationinsights.extensibility.TelemetryInitializer;
import com.microsoft.applicationinsights.telemetry.Telemetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RoleNameTelemetryInitializer implements TelemetryInitializer {

    @Value("${spring.application.role}")
    private String roleName;

    @Override
    public void initialize(Telemetry telemetry) {
        telemetry.getContext().getCloud().setRole(roleName);
    }
}

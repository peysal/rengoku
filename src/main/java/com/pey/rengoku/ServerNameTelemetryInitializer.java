package com.pey.rengoku;

import com.microsoft.applicationinsights.extensibility.TelemetryInitializer;
import com.microsoft.applicationinsights.telemetry.Telemetry;
import org.springframework.beans.factory.annotation.Value;

public class ServerNameTelemetryInitializer implements TelemetryInitializer {

    @Value("${spring.application.server-name}")
    private String serverName;

    @Override
    public void initialize(Telemetry telemetry) {
        telemetry.getContext().getCloud().setRoleInstance(serverName);
    }
}

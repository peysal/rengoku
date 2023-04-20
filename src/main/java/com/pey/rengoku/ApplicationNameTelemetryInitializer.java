package com.pey.rengoku;

import com.microsoft.applicationinsights.extensibility.TelemetryInitializer;
import com.microsoft.applicationinsights.telemetry.Telemetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationNameTelemetryInitializer implements TelemetryInitializer {

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public void initialize(Telemetry telemetry) {
        telemetry.getProperties().put("ApplicationName", applicationName);
    }
}

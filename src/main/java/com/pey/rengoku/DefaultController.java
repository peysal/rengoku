package com.pey.rengoku;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/default")
public class DefaultController {

    @GetMapping
    public ResponseEntity<Map<String, String>> getDefault(@RequestParam(required = false) String optionalParam,
                                                          @RequestParam String mandatoryParam,
                                                          @RequestHeader(value = "correlationId", required = true) String correlationId,
                                                          @RequestHeader(value = "dateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime dateTime) {
        Map<String, String> response = new HashMap<>();
        response.put("optionalParam", optionalParam);
        response.put("mandatoryParam", mandatoryParam);
        return ResponseEntity.ok().header("correlationId", correlationId).header("dateTime", dateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)).body(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> postDefault(@RequestBody Map<String, String> request,
                                                           @RequestHeader(value = "correlationId", required = true) String correlationId,
                                                           @RequestHeader(value = "dateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime dateTime) {
        return ResponseEntity.ok().header("correlationId", correlationId).header("dateTime", dateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)).body(request);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDefault(@RequestHeader(value = "correlationId", required = true) String correlationId,
                                              @RequestHeader(value = "dateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime dateTime) {
        return ResponseEntity.noContent().header("correlationId", correlationId).header("dateTime", dateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> putDefault(@PathVariable String id,
                                                          @RequestBody Map<String, String> request,
                                                          @RequestHeader(value = "correlationId", required = true) String correlationId,
                                                          @RequestHeader(value = "dateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime dateTime) {
        request.put("id", id);
        return ResponseEntity.ok().header("correlationId", correlationId).header("dateTime", dateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)).body(request);
    }
}


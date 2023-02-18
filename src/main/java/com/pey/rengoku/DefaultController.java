package com.pey.rengoku;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/default")
public class DefaultController {

    @GetMapping
    public ResponseEntity<Map<String, String>> getDefault(@RequestParam(required = false) String optionalParam,
                                                          @RequestParam String mandatoryParam,
                                                          @RequestHeader(value = "Correlation-Id", required = true) String correlationId,
                                                          @RequestHeader(value = "Timestamp", required = false) String timestamp) {
        Map<String, String> response = new HashMap<>();
        response.put("optionalParam", optionalParam);
        response.put("mandatoryParam", mandatoryParam);
        return ResponseEntity.ok().header("Correlation-Id", correlationId).header("Timestamp", timestamp).body(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> postDefault(@RequestBody Map<String, String> request,
                                                           @RequestHeader(value = "Correlation-Id", required = true) String correlationId,
                                                           @RequestHeader(value = "Timestamp", required = false) String timestamp) {
        return ResponseEntity.ok().header("Correlation-Id", correlationId).header("Timestamp", timestamp).body(request);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDefault(@RequestHeader(value = "Correlation-Id", required = true) String correlationId,
                                              @RequestHeader(value = "Timestamp", required = false) String timestamp) {
        return ResponseEntity.noContent().header("Correlation-Id", correlationId).header("Timestamp", timestamp).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> putDefault(@PathVariable String id,
                                                          @RequestBody Map<String, String> request,
                                                          @RequestHeader(value = "Correlation-Id", required = true) String correlationId,
                                                          @RequestHeader(value = "Timestamp", required = false) String timestamp) {
        request.put("id", id);
        return ResponseEntity.ok().header("Correlation-Id", correlationId).header("Timestamp", timestamp).body(request);
    }
}


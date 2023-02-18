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
                                                          @RequestHeader(value = "correlationId", required = true) String correlationId,
                                                          @RequestHeader(value = "dateTime", required = false) String dateTime) {
        Map<String, String> response = new HashMap<>();
        response.put("optionalParam", optionalParam);
        response.put("mandatoryParam", mandatoryParam);
        return ResponseEntity.ok().header("correlationId", correlationId).header("dateTime", dateTime).body(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> postDefault(@RequestBody Map<String, String> request,
                                                           @RequestHeader(value = "correlationId", required = true) String correlationId,
                                                           @RequestHeader(value = "dateTime", required = false) String dateTime) {
        return ResponseEntity.ok().header("correlationId", correlationId).header("dateTime", dateTime).body(request);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDefault(@RequestHeader(value = "correlationId", required = true) String correlationId,
                                              @RequestHeader(value = "dateTime", required = false) String dateTime) {
        return ResponseEntity.noContent().header("correlationId", correlationId).header("dateTime", dateTime).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> putDefault(@PathVariable String id,
                                                          @RequestBody Map<String, String> request,
                                                          @RequestHeader(value = "correlationId", required = true) String correlationId,
                                                          @RequestHeader(value = "dateTime", required = false) String dateTime) {
        request.put("id", id);
        return ResponseEntity.ok().header("correlationId", correlationId).header("dateTime", dateTime).body(request);
    }
}


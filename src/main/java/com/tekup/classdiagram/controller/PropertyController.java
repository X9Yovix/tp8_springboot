package com.tekup.classdiagram.controller;

import com.tekup.classdiagram.payload.request.CUPropertyRequest;
import com.tekup.classdiagram.service.PropertyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/properties")
@AllArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;

    @PostMapping("/")
    public ResponseEntity<?> createProperty(@Valid @RequestBody CUPropertyRequest request) {
        return ResponseEntity.ok(this.propertyService.createProperty(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProperty(@PathVariable("id") Long id, @Valid @RequestBody CUPropertyRequest request) {
        return ResponseEntity.ok(this.propertyService.updateProperty(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProperty(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.propertyService.getPropertyById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProperties() {
        return ResponseEntity.ok(this.propertyService.getAllProperties());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.propertyService.deleteProperty(id));
    }
}

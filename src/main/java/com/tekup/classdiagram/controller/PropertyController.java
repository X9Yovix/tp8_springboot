package com.tekup.classdiagram.controller;

import com.tekup.classdiagram.model.Property;
import com.tekup.classdiagram.payload.request.CreatePropertyRequest;
import com.tekup.classdiagram.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/properties")
@AllArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;

    @PostMapping("/")
    public ResponseEntity<?> createProperty(@RequestBody CreatePropertyRequest request) {
        return ResponseEntity.ok(this.propertyService.createProperty(request));
    }
}

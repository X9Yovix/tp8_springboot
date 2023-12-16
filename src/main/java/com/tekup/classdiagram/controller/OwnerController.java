package com.tekup.classdiagram.controller;

import com.tekup.classdiagram.payload.request.CUOwnerRequest;
import com.tekup.classdiagram.service.OwnerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owners")
@AllArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    @PostMapping("/")
    public ResponseEntity<?> createOwner(@Valid @RequestBody CUOwnerRequest request) {
        return ResponseEntity.ok(this.ownerService.createOwner(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOwner(@PathVariable("id") Long id, @Valid @RequestBody CUOwnerRequest request) {
        return ResponseEntity.ok(this.ownerService.updateOwner(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOwnerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.ownerService.getOwnerById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllOwners() {
        return ResponseEntity.ok(this.ownerService.getAllOwners());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.ownerService.deleteOwner(id));
    }
}

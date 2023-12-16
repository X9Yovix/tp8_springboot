package com.tekup.classdiagram.controller;

import com.tekup.classdiagram.payload.request.CURentalContractRequest;
import com.tekup.classdiagram.service.RentalContractService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rental-contracts")
@AllArgsConstructor
public class RentalContractController {
    private final RentalContractService rentalContractService;

    @PostMapping("/")
    public ResponseEntity<?> createRentalContract(@RequestBody CURentalContractRequest request) {
        return ResponseEntity.ok(this.rentalContractService.createRentalContract(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRentalContract(@PathVariable("id") Long id, @RequestBody CURentalContractRequest request) {
        return ResponseEntity.ok(this.rentalContractService.updateRentalContract(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRentalContractById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.rentalContractService.getRentalContractById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllRentalContracts() {
        return ResponseEntity.ok(this.rentalContractService.getAllRentalContracts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRentalContract(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.rentalContractService.deleteRentalContract(id));
    }
}

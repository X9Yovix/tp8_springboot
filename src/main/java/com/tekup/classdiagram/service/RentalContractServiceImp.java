package com.tekup.classdiagram.service;

import com.tekup.classdiagram.exception.ResourceNotFound;
import com.tekup.classdiagram.model.Owner;
import com.tekup.classdiagram.model.Property;
import com.tekup.classdiagram.model.RentalContract;
import com.tekup.classdiagram.payload.request.CURentalContractRequest;
import com.tekup.classdiagram.payload.response.CURentalContractResponse;
import com.tekup.classdiagram.payload.response.MessageResponse;
import com.tekup.classdiagram.payload.response.RentalContractsResponse;
import com.tekup.classdiagram.repository.OwnerRepository;
import com.tekup.classdiagram.repository.PropertyRepository;
import com.tekup.classdiagram.repository.RentalContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RentalContractServiceImp implements RentalContractService {
    private final PropertyRepository propertyRepository;
    private final OwnerRepository ownerRepository;
    private final RentalContractRepository rentalContractRepository;

    private Property findPropertyById(Long id) throws ResourceNotFound {
        Optional<Property> propertyOptional = this.propertyRepository.findById(id);
        if (propertyOptional.isPresent()) {
            return propertyOptional.get();
        } else {
            throw new ResourceNotFound("Property not found with id: " + id);
        }
    }

    private Owner findOwnerById(Long id) throws ResourceNotFound {
        Optional<Owner> ownerOptional = this.ownerRepository.findById(id);
        if (ownerOptional.isPresent()) {
            return ownerOptional.get();
        } else {
            throw new ResourceNotFound("Owner not found with id: " + id);
        }
    }

    @Override
    public Object createRentalContract(CURentalContractRequest request) {
        try {
            RentalContract rentalContract = RentalContract.builder()
                    .property(this.findPropertyById(request.getPropertyId()))
                    .owner(this.findOwnerById(request.getOwnerId()))
                    .tenant(request.getTenant())
                    .monthlyRent(request.getMonthlyRent())
                    .build();
            RentalContract savedRentalContract = this.rentalContractRepository.save(rentalContract);
            return CURentalContractResponse.builder()
                    .rentalContract(savedRentalContract)
                    .message("Rental Contract saved")
                    .httpStatus(HttpStatus.CREATED.value())
                    .build();
        } catch (Exception e) {
            return MessageResponse.builder()
                    .message("Unexpected error occurred")
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
        }
    }

    @Override
    public Object getAllRentalContracts() {
        return RentalContractsResponse.builder()
                .rentalContracts(this.rentalContractRepository.findAll())
                .message("Rental Contracts found")
                .httpStatus(HttpStatus.OK.value())
                .build();
    }


    private RentalContract findRentalContractById(Long id) throws ResourceNotFound {
        Optional<RentalContract> findProperty = this.rentalContractRepository.findById(id);
        if (findProperty.isPresent()) {
            return findProperty.get();
        } else {
            throw new ResourceNotFound("Rental Contract not found with id: " + id);
        }
    }

    @Override
    public Object getRentalContractById(Long id) {
        try {
            return CURentalContractResponse.builder()
                    .rentalContract(this.findRentalContractById(id))
                    .message("Rental Contract found")
                    .httpStatus(HttpStatus.OK.value())
                    .build();
        } catch (Exception e) {
            return MessageResponse.builder()
                    .message("Unexpected error occurred")
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
        }
    }

    @Override
    public Object updateRentalContract(Long id, CURentalContractRequest request) {
        try {
            RentalContract existingRentalContract = this.findRentalContractById(id);
            existingRentalContract.setProperty(this.findPropertyById(request.getPropertyId()));
            existingRentalContract.setOwner(this.findOwnerById(request.getOwnerId()));
            existingRentalContract.setTenant(request.getTenant());
            existingRentalContract.setMonthlyRent(request.getMonthlyRent());
            RentalContract updatedRentalContract = this.rentalContractRepository.save(existingRentalContract);
            return CURentalContractResponse.builder()
                    .rentalContract(updatedRentalContract)
                    .message("Rental Contract updated")
                    .httpStatus(HttpStatus.CREATED.value())
                    .build();
        } catch (Exception e) {
            return MessageResponse.builder()
                    .message("Unexpected error occurred")
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
        }
    }

    @Override
    public Object deleteRentalContract(Long id) {
        try {
            RentalContract rentalContract = this.findRentalContractById(id);
            this.rentalContractRepository.delete(rentalContract);
            return MessageResponse.builder()
                    .message("Rental Contract deleted successfully")
                    .httpStatus(HttpStatus.NO_CONTENT.value())
                    .build();
        } catch (Exception e) {
            return MessageResponse.builder()
                    .message("Unexpected error occurred")
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
        }
    }
}

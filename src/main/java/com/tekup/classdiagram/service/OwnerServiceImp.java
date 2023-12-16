package com.tekup.classdiagram.service;

import com.tekup.classdiagram.exception.ResourceNotFound;
import com.tekup.classdiagram.model.Owner;
import com.tekup.classdiagram.model.Property;
import com.tekup.classdiagram.payload.request.CUOwnerRequest;
import com.tekup.classdiagram.payload.response.*;
import com.tekup.classdiagram.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OwnerServiceImp implements OwnerService {
    private final OwnerRepository ownerRepository;

    @Override
    public Object createOwner(CUOwnerRequest request) {
        Owner owner = Owner.builder()
                .name(request.getName())
                .contactInformation(request.getContactInformation())
                .build();
        try {
            Owner savedOwner = this.ownerRepository.save(owner);
            return CUOwnerResponse.builder()
                    .owner(savedOwner)
                    .message("Owner saved")
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
    public Object getAllOwners() {
        return OwnersResponse.builder()
                .owners(this.ownerRepository.findAll())
                .message("Owners found")
                .httpStatus(HttpStatus.OK.value())
                .build();
    }


    private Owner findOwnerById(Long id) throws ResourceNotFound {
        Optional<Owner> findOwner = this.ownerRepository.findById(id);
        if (findOwner.isPresent()) {
            return findOwner.get();
        } else {
            throw new ResourceNotFound("Owner not found with id: " + id);
        }
    }

    @Override
    public Object getOwnerById(Long id) {
        try {
            return CUOwnerResponse.builder()
                    .owner(this.findOwnerById(id))
                    .message("Owner found")
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
    public Object updateOwner(Long id, CUOwnerRequest request) {
        try {
            Owner existingOwner = this.findOwnerById(id);
            existingOwner.setName(request.getName());
            existingOwner.setContactInformation(request.getContactInformation());
            Owner updatedOwner = this.ownerRepository.save(existingOwner);
            return CUOwnerResponse.builder()
                    .owner(updatedOwner)
                    .message("Owner updated")
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
    public Object deleteOwner(Long id) {
        try {
            Owner owner = this.findOwnerById(id);
            this.ownerRepository.delete(owner);
            return MessageResponse.builder()
                    .message("Owner deleted successfully")
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

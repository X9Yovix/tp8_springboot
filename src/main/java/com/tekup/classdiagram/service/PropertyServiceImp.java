package com.tekup.classdiagram.service;

import com.tekup.classdiagram.exception.ResourceNotFound;
import com.tekup.classdiagram.model.Property;
import com.tekup.classdiagram.payload.request.CUPropertyRequest;
import com.tekup.classdiagram.payload.response.CUPropertyResponse;
import com.tekup.classdiagram.payload.response.MessageResponse;
import com.tekup.classdiagram.payload.response.PropertiesResponse;
import com.tekup.classdiagram.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PropertyServiceImp implements PropertyService {
    private final PropertyRepository propertyRepository;

    @Override
    public Object createProperty(CUPropertyRequest request) {
        Property property = Property.builder()
                .address(request.getAddress())
                .price(request.getPrice())
                .build();

        try {
            Property savedProperty = this.propertyRepository.save(property);
            return CUPropertyResponse.builder()
                    .property(savedProperty)
                    .message("Property saved")
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
    public Object getAllProperties() {
        return PropertiesResponse.builder()
                .properties(this.propertyRepository.findAll())
                .message("Properties found")
                .httpStatus(HttpStatus.OK.value())
                .build();
    }


    private Property findPropertyById(Long id) throws ResourceNotFound {
        Optional<Property> findProperty = this.propertyRepository.findById(id);
        if (findProperty.isPresent()) {
            return findProperty.get();
        } else {
            throw new ResourceNotFound("Property not found with id: " + id);
        }
    }

    @Override
    public Object getPropertyById(Long id) {
        try {
            return CUPropertyResponse.builder()
                    .property(this.findPropertyById(id))
                    .message("Property found")
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
    public Object updateProperty(Long id, CUPropertyRequest request) {
        try {
            Property existingProperty = this.findPropertyById(id);
            existingProperty.setAddress(request.getAddress());
            existingProperty.setPrice(request.getPrice());
            Property updatedProperty = this.propertyRepository.save(existingProperty);
            return CUPropertyResponse.builder()
                    .property(updatedProperty)
                    .message("Property updated")
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
    public Object deleteProperty(Long id) {
        try {
            Property property = this.findPropertyById(id);
            this.propertyRepository.delete(property);
            return MessageResponse.builder()
                    .message("Property deleted successfully")
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

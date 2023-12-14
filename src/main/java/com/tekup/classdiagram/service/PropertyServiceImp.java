package com.tekup.classdiagram.service;

import com.tekup.classdiagram.exception.ResourceNotFound;
import com.tekup.classdiagram.model.Property;
import com.tekup.classdiagram.payload.request.CUPropertyRequest;
import com.tekup.classdiagram.payload.response.CUPropertyResponse;
import com.tekup.classdiagram.payload.response.MessageResponse;
import com.tekup.classdiagram.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
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
            System.out.println(savedProperty);
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
    public List<Property> getAllProperties() {
        return null;
    }

    @Override
    public Optional<Property> getPropertyById(Long id) {
        return Optional.empty();
    }

    @Override
    public Object updateProperty(Long id, CUPropertyRequest request) {
        try {
            Optional<Property> findProperty = this.propertyRepository.findById(id);
            if (findProperty.isPresent()) {
                Property existingProperty = findProperty.get();
                existingProperty.setAddress(request.getAddress());
                existingProperty.setPrice(request.getPrice());

                Property updatedProperty = this.propertyRepository.save(existingProperty);

                return CUPropertyResponse.builder()
                        .property(updatedProperty)
                        .message("Property updated")
                        .httpStatus(HttpStatus.CREATED.value())
                        .build();
            } else {
                throw new ResourceNotFound("Property not found with id: " + id);
            }
        } catch (Exception e) {
            return MessageResponse.builder()
                    .message("Unexpected error occurred")
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
        }
    }

    @Override
    public void deleteProperty(Long id) {

    }
}

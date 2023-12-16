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
            Property updatedProperty = this.propertyRepository.save(this.findPropertyById(id));
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
    public void deleteProperty(Long id) {

    }
}

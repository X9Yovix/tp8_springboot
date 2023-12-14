package com.tekup.classdiagram.service;

import com.tekup.classdiagram.model.Property;
import com.tekup.classdiagram.payload.request.CreatePropertyRequest;
import com.tekup.classdiagram.payload.response.CreatePropertyResponse;
import com.tekup.classdiagram.payload.response.MessageResponse;
import com.tekup.classdiagram.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PropertyServiceImp implements PropertyService{
    private final PropertyRepository propertyRepository;

    @Override
    public Object createProperty(CreatePropertyRequest request) {
        Property property = Property.builder()
                .address(request.getAddress())
                .price(request.getPrice())
                .build();

        try {
            Property savedProperty = this.propertyRepository.save(property);
            System.out.println(savedProperty);
            return CreatePropertyResponse.builder()
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
    public Property updateProperty(Long id, Property updatedProperty) {
        return null;
    }

    @Override
    public void deleteProperty(Long id) {

    }
}

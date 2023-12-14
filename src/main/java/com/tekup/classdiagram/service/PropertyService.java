package com.tekup.classdiagram.service;

import com.tekup.classdiagram.model.Property;
import com.tekup.classdiagram.payload.request.CreatePropertyRequest;
import com.tekup.classdiagram.payload.response.CreatePropertyResponse;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    //C
    Object createProperty(CreatePropertyRequest request);
    //R
    public List<Property> getAllProperties();
    Optional<Property> getPropertyById(Long id);
    //U
    public Property updateProperty(Long id, Property updatedProperty);
    //D
    public void deleteProperty(Long id);
}

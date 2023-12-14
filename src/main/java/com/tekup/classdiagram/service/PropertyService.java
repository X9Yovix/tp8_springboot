package com.tekup.classdiagram.service;

import com.tekup.classdiagram.model.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    //C
    public Property createProperty(Property property);
    //R
    public List<Property> getAllProperties();
    Optional<Property> getPropertyById(Long id);
    //U
    public Property updateProperty(Long id, Property updatedProperty);
    //D
    public void deleteProperty(Long id);
}

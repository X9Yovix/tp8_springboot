package com.tekup.classdiagram.service;

import com.tekup.classdiagram.model.Property;
import com.tekup.classdiagram.payload.request.CUPropertyRequest;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    //C
    Object createProperty(CUPropertyRequest request);

    //R
    Object getAllProperties();

    Object getPropertyById(Long id);

    //U
    Object updateProperty(Long id, CUPropertyRequest request);

    //D
    Object deleteProperty(Long id);
}

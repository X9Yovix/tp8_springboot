package com.tekup.classdiagram.service;

import com.tekup.classdiagram.model.Property;
import com.tekup.classdiagram.payload.request.CUPropertyRequest;
import com.tekup.classdiagram.payload.response.CUPropertyResponse;
import com.tekup.classdiagram.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PropertyServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(PropertyServiceTest.class);

    @Mock
    private PropertyRepository propertyRepository;

    @InjectMocks
    private PropertyServiceImp propertyService;

    @Test
    void testCreateProperty() {
        logger.info("Running Test");

        CUPropertyRequest request = new CUPropertyRequest();
        request.setAddress("Test Address");
        request.setPrice(1000.0);

        Property mockProperty = new Property();
        mockProperty.setId(1L);
        mockProperty.setAddress(request.getAddress());
        mockProperty.setPrice(request.getPrice());

        when(this.propertyRepository.save(Mockito.any(Property.class))).thenReturn(mockProperty);

        Object response = this.propertyService.createProperty(request);

        assertTrue(response instanceof CUPropertyResponse);

        CUPropertyResponse propertyResponse = (CUPropertyResponse) response;
        assertEquals(mockProperty.getId(), propertyResponse.getProperty().getId());
        assertEquals(mockProperty.getAddress(), propertyResponse.getProperty().getAddress());
        assertEquals(mockProperty.getPrice(), propertyResponse.getProperty().getPrice());
        assertEquals("Property saved", propertyResponse.getMessage());
        assertEquals(HttpStatus.CREATED.value(), propertyResponse.getHttpStatus());

        logger.info("Test completed successfully");
    }
}

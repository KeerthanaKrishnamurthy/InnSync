package com.innsync.property;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PropertyServiceTest {

    @Mock
    private PropertyRepository propertyRepository;

    private PropertyService propertyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        propertyService = new PropertyService(propertyRepository);
    }

    @Test
    void shouldCreateProperty() {

        Property property =
                new Property("Sunrise Beach Resort", "Goa", "India");

        when(propertyRepository.save(property))
                .thenReturn(property);

        Property result =
                propertyService.createProperty(property);

        assertEquals("Sunrise Beach Resort", result.getName());
        assertEquals("Goa", result.getCity());
        assertEquals("India", result.getCountry());

        verify(propertyRepository, times(1))
                .save(property);
    }

    @Test
    void shouldReturnAllProperties() {

        Property property1 =
                new Property("Sunrise Beach Resort", "Goa", "India");

        Property property2 =
                new Property("Mountain View Hotel", "Manali", "India");

        when(propertyRepository.findAll())
                .thenReturn(List.of(property1, property2));

        List<Property> result =
                propertyService.getAllProperties();

        assertEquals(2, result.size());

        verify(propertyRepository, times(1))
                .findAll();
    }
}
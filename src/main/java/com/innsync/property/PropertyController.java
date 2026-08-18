package com.innsync.property;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<Property> createProperty(
            @RequestBody Property property) {

        Property createdProperty =
                propertyService.createProperty(property);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdProperty);
    }

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {

        return ResponseEntity.ok(
                propertyService.getAllProperties()
        );
    }
}
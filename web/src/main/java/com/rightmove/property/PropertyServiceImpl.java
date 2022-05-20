package com.rightmove.property;

import com.rightmove.property.dto.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyDataClient propertyDataClient;

    @Autowired
    public PropertyServiceImpl(PropertyDataClient propertyDataClient) {
        this.propertyDataClient = propertyDataClient;
    }


    @Override
    public List<Property> getProperties() {
        return propertyDataClient.getPropertyData().getProperties();
    }
}

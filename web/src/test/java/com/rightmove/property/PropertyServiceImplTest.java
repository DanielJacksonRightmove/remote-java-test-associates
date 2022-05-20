package com.rightmove.property;

import com.rightmove.datasetup.PropertyBuilder;
import com.rightmove.property.dto.Property;
import com.rightmove.property.dto.PropertyDataDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PropertyServiceImplTest {

    @Mock
    private PropertyDataClient propertyDataClient;

    private PropertyServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new PropertyServiceImpl(propertyDataClient);
    }

    @Test
    void shouldReturnProperties() {
        Property property = PropertyBuilder.aDefaultPropertyEntity(1).postcode("W1D 3QU").build();
        Property property2 = PropertyBuilder.aDefaultPropertyEntity(2).postcode("W1F 3FT").build();
        PropertyDataDTO propertyDataDTO = new PropertyDataDTO(List.of(property, property2));

        when(propertyDataClient.getPropertyData()).thenReturn(propertyDataDTO);

        List<Property> properties = underTest.getProperties();

        assertThat(properties.size()).isEqualTo(2);
    }

}
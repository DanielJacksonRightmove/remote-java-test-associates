package com.rightmove.property.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;
import java.util.Objects;

@JsonDeserialize(builder = PropertyDataDTO.Builder.class)
public class PropertyDataDTO {

    private final List<Property> properties;

    public PropertyDataDTO(List<Property> properties) {
        this.properties = properties;
    }

    public List<Property> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyDataDTO that = (PropertyDataDTO) o;
        return Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(properties);
    }


    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private List<Property> properties;

        private Builder() {
        }

        public static Builder aPropertyDataDTO() {
            return new Builder();
        }

        public Builder properties(List<Property> properties) {
            this.properties = properties;
            return this;
        }

        public PropertyDataDTO build() {
            return new PropertyDataDTO(properties);
        }
    }
}

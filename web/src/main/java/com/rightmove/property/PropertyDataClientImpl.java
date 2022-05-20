package com.rightmove.property;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rightmove.property.dto.PropertyDataDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Component
public class PropertyDataClientImpl implements PropertyDataClient {

    private final ObjectMapper objectMapper;
    private final HttpClient httpClient;
    private final String propertyDataUrl;

    public PropertyDataClientImpl(ObjectMapper objectMapper,
                                  HttpClient httpClient,
                                  @Value("${property.data.url}") String propertyDataUrl) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
        this.propertyDataUrl = propertyDataUrl;
    }

    @Override
    public PropertyDataDTO getPropertyData() {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getPropertyDataUri())
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                var propertyDataDTO = objectMapper.readValue(response.body(), PropertyDataDTO.class);
                return propertyDataDTO;
            } else {
                return new PropertyDataDTO(List.of());
            }
        } catch (Exception e) {
            return new PropertyDataDTO(List.of());
        }

    }

    private URI getPropertyDataUri() {
        return UriComponentsBuilder.fromUriString(propertyDataUrl)
                .build()
                .toUri();
    }

}

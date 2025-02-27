package flux.system.logistics.application.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record AddressCreateRequest(
        @Size(max = 100, message = "City name must be less than 100 characters")
        String cityName,

        @Size(max = 100, message = "Country name must be less than 100 characters")
        String countryName,

        @NotNull(message = "Latitude is required")
        BigDecimal latitude,

        @NotNull(message = "Longitude is required")
        BigDecimal longitude
) {
}

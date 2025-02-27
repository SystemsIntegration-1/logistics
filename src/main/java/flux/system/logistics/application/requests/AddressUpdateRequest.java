package flux.system.logistics.application.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AddressUpdateRequest(
        @NotBlank(message = "City name cannot be blank")
        String cityName,

        @NotBlank(message = "Country name cannot be blank")
        String countryName,

        @NotNull(message = "Latitude is required")
        BigDecimal latitude,

        @NotNull(message = "Longitude is required")
        BigDecimal longitude
) {
}

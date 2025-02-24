package flux.logistic.application.requests;

import java.math.BigDecimal;

public record AddressUpdateRequest(
        String cityName,
        String countryName,
        BigDecimal latitude,
        BigDecimal longitude
) {
}

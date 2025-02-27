package flux.system.logistics.application.responses;

import java.math.BigDecimal;
import java.util.UUID;

public record AddressResponse(
        UUID addressId,
        String cityName,
        String countryName,
        BigDecimal latitude,
        BigDecimal longitude
) {
}

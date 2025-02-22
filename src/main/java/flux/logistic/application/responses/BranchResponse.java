package flux.logistic.application.responses;

import java.math.BigDecimal;
import java.util.UUID;

public record BranchResponse(
        UUID branchId,
        String branchName,
        String cityName,
        String countryName,
        BigDecimal latitude,
        BigDecimal longitude
) {
}

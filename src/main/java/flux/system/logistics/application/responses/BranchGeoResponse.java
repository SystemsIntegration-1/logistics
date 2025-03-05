package flux.system.logistics.application.responses;

import flux.system.logistics.domain.entities.Address;

import java.math.BigDecimal;
import java.util.UUID;

public record BranchGeoResponse(
       UUID branchID,
       String branchName,
       BigDecimal latitude,
       BigDecimal longitude
) {
}

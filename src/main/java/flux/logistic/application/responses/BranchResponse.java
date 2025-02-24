package flux.logistic.application.responses;

import java.util.UUID;

public record BranchResponse(
        UUID branchId,
        String branchName,
        AddressResponse address,
        ContactResponse contact
) {
}

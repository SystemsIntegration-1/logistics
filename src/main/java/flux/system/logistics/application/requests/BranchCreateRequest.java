package flux.system.logistics.application.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BranchCreateRequest(
        @NotBlank(message = "Branch name is required")
        String branchName,

        @NotNull(message = "Address is required")
        AddressCreateRequest address,

        @NotNull(message = "Contact is required")
        ContactCreateRequest contact
) {
}

package flux.system.logistics.application.requests;

import jakarta.validation.constraints.NotBlank;

public record BranchUpdateRequest(
        @NotBlank(message = "Branch name cannot be blank")
        String branchName,

        AddressUpdateRequest address,
        ContactUpdateRequest contact
) {
}

package flux.logistic.application.requests;

public record BranchUpdateRequest(
        String branchName,
        AddressUpdateRequest address,
        ContactUpdateRequest contact
) {
}

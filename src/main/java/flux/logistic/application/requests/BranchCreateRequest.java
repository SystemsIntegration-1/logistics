package flux.logistic.application.requests;

public record BranchCreateRequest(
        String branchName,
        AddressCreateRequest address,
        ContactCreateRequest contact
) {
}

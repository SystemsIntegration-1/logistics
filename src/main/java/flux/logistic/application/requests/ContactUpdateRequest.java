package flux.logistic.application.requests;

public record ContactUpdateRequest(
        String name,
        String email,
        String phone
) {
}

package flux.logistic.application.requests;

public record ContactCreateRequest(
        String name,
        String email,
        String phone
) {
}

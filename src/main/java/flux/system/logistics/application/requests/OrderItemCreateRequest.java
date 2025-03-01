package flux.system.logistics.application.requests;

import java.util.UUID;

public record OrderItemCreateRequest(
        UUID productId,
        String productName,
        String productDescription,
        int quantity,
        String notes
) {
}

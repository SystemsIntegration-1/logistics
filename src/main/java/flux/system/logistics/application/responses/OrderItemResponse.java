package flux.system.logistics.application.responses;

import java.util.UUID;

public record OrderItemResponse(
        UUID itemId,
        UUID productId,
        String productName,
        String productDescription,
        int quantity,
        String notes
) {
}

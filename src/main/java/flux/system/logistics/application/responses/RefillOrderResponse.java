package flux.system.logistics.application.responses;

import flux.system.logistics.domain.entities.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record RefillOrderResponse(
        UUID orderId,
        OrderStatus status,
        BranchResponse branch,
        List<OrderItemResponse> items,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}

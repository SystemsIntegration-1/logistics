package flux.system.logistics.application.requests;

import java.util.List;
import java.util.UUID;

public record RefillOrderCreateRequest(
        UUID branchId,
        List<OrderItemCreateRequest> items
) {
}

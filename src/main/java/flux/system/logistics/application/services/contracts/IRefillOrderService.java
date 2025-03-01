package flux.system.logistics.application.services.contracts;

import flux.system.logistics.application.requests.RefillOrderCreateRequest;
import flux.system.logistics.application.responses.RefillOrderResponse;
import flux.system.logistics.domain.entities.OrderStatus;

import java.util.List;
import java.util.UUID;

public interface IRefillOrderService {
    RefillOrderResponse getRefillOrderById(UUID orderId);

    List<RefillOrderResponse> getAllRefillOrders();

    RefillOrderResponse createRefillOrder(RefillOrderCreateRequest orderCreateRequest);

    RefillOrderResponse updateRefillOrderStatus(UUID orderId, OrderStatus status);

    boolean deleteRefillOrderById(UUID orderId);
}

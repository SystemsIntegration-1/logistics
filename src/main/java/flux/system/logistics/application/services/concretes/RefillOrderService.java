package flux.system.logistics.application.services.concretes;

import flux.system.logistics.application.mappers.IBranchMapper;
import flux.system.logistics.application.mappers.IOrderItemMapper;
import flux.system.logistics.application.mappers.IRefillOrderMapper;
import flux.system.logistics.application.requests.RefillOrderCreateRequest;
import flux.system.logistics.application.responses.BranchResponse;
import flux.system.logistics.application.responses.RefillOrderResponse;
import flux.system.logistics.application.services.contracts.IBranchService;
import flux.system.logistics.application.services.contracts.IRefillOrderService;
import flux.system.logistics.application.services.external.InventaryService;
import flux.system.logistics.application.services.external.mapper.InventoryMapper;
import flux.system.logistics.application.services.external.model.InventoryMovementRequest;
import flux.system.logistics.domain.entities.Branch;
import flux.system.logistics.domain.entities.OrderItem;
import flux.system.logistics.domain.entities.OrderStatus;
import flux.system.logistics.domain.entities.RefillOrder;
import flux.system.logistics.domain.repositories.IRefillOrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RefillOrderService implements IRefillOrderService {
    private final IRefillOrderRepository refillOrderRepository;
    private final IBranchService branchService;
    private final IBranchMapper branchMapper;
    private final IRefillOrderMapper refillOrderMapper;
    private final IOrderItemMapper orderItemMapper;
    private InventaryService inventaryService;

    public RefillOrderService(IRefillOrderRepository refillOrderRepository,
                              IBranchService branchService,
                              IBranchMapper branchMapper,
                              IOrderItemMapper orderItemMapper,
                              IRefillOrderMapper refillOrderMapper) {
        this.refillOrderRepository = refillOrderRepository;
        this.branchService = branchService;
        this.branchMapper = branchMapper;
        this.orderItemMapper = orderItemMapper;
        this.refillOrderMapper = refillOrderMapper;
    }

    @Override
    public RefillOrderResponse getRefillOrderById(UUID orderId) {
        return refillOrderRepository
                .findById(orderId)
                .map(refillOrderMapper::mapEntityToRefillOrderResponse)
                .orElseThrow(() -> new RuntimeException("Refill order not found with id: " + orderId));
    }

    @Override
    public List<RefillOrderResponse> getAllRefillOrders() {
        return refillOrderRepository.findAll()
                .stream()
                .map(refillOrderMapper::mapEntityToRefillOrderResponse)
                .toList();
    }

    @Override
    public RefillOrderResponse createRefillOrder(RefillOrderCreateRequest request) {
        BranchResponse branchResponse = branchService
                .getBranchById(request.branchId())
                .orElseThrow(() -> new RuntimeException("Branch not found with id: " + request.branchId()));

        Branch branch = branchMapper.mapBranchResponseToEntity(branchResponse);

        RefillOrder refillOrder = new RefillOrder();
        refillOrder.setBranch(branch);
        refillOrder.setStatus(OrderStatus.PENDING);
        refillOrder.setCreatedAt(LocalDateTime.now());

        List<OrderItem> orderItems = request
                .items()
                .stream()
                .map(orderItemRequest -> {
                    OrderItem orderItem = orderItemMapper.mapCreateRequestToEntity(orderItemRequest);
                    orderItem.setRefillOrder(refillOrder);

                    return orderItem;
                })
                .toList();

        if (refillOrder != null && refillOrder.getItems() != null) {
            for (int x = 0; x < refillOrder.getItems().size(); x++) {
                InventoryMovementRequest inventoryMovementRequest = InventoryMapper.mapToInventoryMovement(refillOrder, x);
                if (request != null) {
                    inventoryMovementRequest.setProductId(request.items().get(x).productId());
                    inventaryService.postInventoryMovement(inventoryMovementRequest);
                }
            }
        }

        refillOrder.setItems(orderItems);

        refillOrderRepository.save(refillOrder);

        return refillOrderMapper.mapEntityToRefillOrderResponse(refillOrder);
    }

    @Override
    public RefillOrderResponse updateRefillOrderStatus(UUID orderId, OrderStatus status) {
        return refillOrderRepository
                .findById(orderId)
                .map(refillOrder -> {
                    refillOrder.setStatus(status);
                    refillOrderRepository.save(refillOrder);

                    return refillOrderMapper.mapEntityToRefillOrderResponse(refillOrder);
                })
                .orElseThrow(() -> new RuntimeException("Refill order not found with id: " + orderId));
    }

    @Override
    public boolean deleteRefillOrderById(UUID orderId) {
        return refillOrderRepository
                .findById(orderId)
                .map(refillOrder -> {
                    refillOrderRepository.delete(refillOrder);

                    return true;
                })
                .orElse(false);
    }
}

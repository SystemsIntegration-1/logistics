package flux.system.logistics.presentation.controllers;

import flux.system.logistics.application.requests.RefillOrderCreateRequest;
import flux.system.logistics.application.responses.RefillOrderResponse;
import flux.system.logistics.application.services.contracts.IRefillOrderService;

import flux.system.logistics.domain.entities.OrderStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/refills")
public class RefillOrderController {
    private final IRefillOrderService refillOrderService;

    public RefillOrderController(IRefillOrderService refillOrderService) {
        this.refillOrderService = refillOrderService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<RefillOrderResponse> getRefillById(@PathVariable("orderId") UUID orderId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(refillOrderService.getRefillOrderById(orderId));
    }

    @GetMapping
    public ResponseEntity<List<RefillOrderResponse>> getAllRefillOrders() {
        List<RefillOrderResponse> refillOrders = refillOrderService.getAllRefillOrders();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(refillOrders);
    }

    @PostMapping
    public ResponseEntity<RefillOrderResponse> createRefill(@RequestBody RefillOrderCreateRequest orderCreateRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(refillOrderService.createRefillOrder(orderCreateRequest));
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<RefillOrderResponse> updateRefillOrderStatus(
            @PathVariable UUID orderId,
            @RequestParam OrderStatus status) {
        RefillOrderResponse response = refillOrderService.updateRefillOrderStatus(orderId, status);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteRefillOrderById(@PathVariable("orderId") UUID orderId) {
        refillOrderService.deleteRefillOrderById(orderId);
        return ResponseEntity.noContent().build();
    }
}

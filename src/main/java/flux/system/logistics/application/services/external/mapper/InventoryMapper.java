package flux.system.logistics.application.services.external.mapper;

import flux.system.logistics.application.services.external.model.InventoryMovementRequest;
import flux.system.logistics.domain.entities.OrderItem;
import flux.system.logistics.domain.entities.RefillOrder;

import java.time.ZoneId;

public class InventoryMapper {

    public static InventoryMovementRequest mapToInventoryMovement(RefillOrder refill, int indexMed) {
        if (refill == null || refill.getItems() == null || refill.getItems().isEmpty()) {
            return null;
        }

        if (indexMed < 0 || indexMed >= refill.getItems().size()) {
            return null;
        }

        OrderItem medication = refill.getItems().get(indexMed);
        if (medication == null) {
            return null;
        }

        InventoryMovementRequest request = new InventoryMovementRequest();
        request.setProductId(medication.getProductId());
        request.setMovementType("outgoing");
        request.setQuantity(medication.getQuantity());
        request.setMovementDate(refill.getCreatedAt() != null ? refill.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() : System.currentTimeMillis());
        request.setOrigin(refill.getBranch() != null ? refill.getBranch().getBranchName() : "Unknown Branch");
        request.setDestination("Main Warehouse");

        return request;
    }
}

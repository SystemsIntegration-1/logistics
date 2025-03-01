package flux.system.logistics.application.services.external.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryMovementRequest {
    private UUID productId;
    private String movementType;
    private int quantity;
    private long movementDate;
    private String origin;
    private String destination;
}

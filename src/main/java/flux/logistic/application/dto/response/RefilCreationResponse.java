package flux.logistic.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class RefilCreationResponse {
    UUID refill_id;
    int estimated_delivery;
    String message_refill;
}

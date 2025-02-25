package flux.logistic.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefillResponse {
    UUID refill_id;
    int estimated_delivery;
    String message_refill;
}

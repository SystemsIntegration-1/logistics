package flux.system.logistics.application.services.external;

import flux.system.logistics.application.services.external.model.InventoryMovementRequest;
import lombok.NoArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@NoArgsConstructor
public class InventaryService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "http://localhost:5260/inventory/movements";

    public String postInventoryMovement(InventoryMovementRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<InventoryMovementRequest> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                BASE_URL, HttpMethod.POST, requestEntity, String.class
        );

        return response.getBody();
    }
}

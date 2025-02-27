package flux.system.logistics.application.services.contracts;

import flux.system.logistics.application.requests.BranchRefillRequest;
import flux.system.logistics.application.dto.response.RefillResponse;

import java.util.UUID;

public interface IRefillService {
    RefillResponse create (BranchRefillRequest create_refill);
    RefillResponse getById(UUID refillId);
}

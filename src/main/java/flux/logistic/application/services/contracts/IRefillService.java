package flux.logistic.application.services.contracts;

import flux.logistic.application.dto.request.BranchRefillRequest;
import flux.logistic.application.dto.response.RefillResponse;

import java.util.UUID;

public interface IRefillService {
    RefillResponse create (BranchRefillRequest create_refill);
    RefillResponse getById(UUID refillId);
}

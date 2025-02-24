package flux.logistic.application.services.contracts;

import flux.logistic.application.dto.request.BranchRefillRequest;
import flux.logistic.application.dto.response.RefilCreationResponse;
import flux.logistic.domain.entities.Refill;

import java.util.UUID;

public interface IRefillService {
    RefilCreationResponse create (BranchRefillRequest create_refill);
    Refill getById(UUID refillId);
}

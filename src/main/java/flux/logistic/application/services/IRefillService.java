package flux.logistic.application.services;

import flux.logistic.application.dto.request.Branch_Refill_Request;
import flux.logistic.application.dto.response.RefilCreationResponse;
import flux.logistic.domain.entities.Refill;

import java.util.UUID;

public interface IRefillService {
    RefilCreationResponse create (Branch_Refill_Request create_refill);
    Refill getById(UUID refillId);
}

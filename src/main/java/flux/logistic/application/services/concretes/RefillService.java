package flux.logistic.application.services.concretes;

import flux.logistic.application.dto.request.Branch_Refill_Request;
import flux.logistic.application.dto.response.RefilCreationResponse;
import flux.logistic.application.mappers.Refill_mapper;
import flux.logistic.application.services.IRefillService;
import flux.logistic.domain.entities.Refill;
import flux.logistic.domain.repositories.IRefillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RefillService implements IRefillService{

    private final IRefillRepository refillRepository;

    @Override
    public RefilCreationResponse create(Branch_Refill_Request create_refill) {
        Refill refill = refillRepository.saveAndFlush(Refill_mapper.branchRequestToRefill(create_refill));
        return new RefilCreationResponse(refill.getRefillId(), 10, "Refill requested");
    }

    @Override
    public Refill getById(UUID refillId) {
        return refillRepository.getById(refillId);
    }
}

package flux.logistic.application.services.concretes;

import flux.logistic.application.dto.request.BranchRefillRequest;
import flux.logistic.application.dto.response.RefilCreationResponse;
import flux.logistic.application.mappers.RefillMapper;
import flux.logistic.application.services.contracts.IRefillService;
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
    public RefilCreationResponse create(BranchRefillRequest create_refill) {
        Refill refill = refillRepository.saveAndFlush(RefillMapper.branchRequestToRefill(create_refill));
        return new RefilCreationResponse(refill.getRefillId(), 10, "Refill requested");
    }

    @Override
    public Refill getById(UUID refillId) {
        return refillRepository.getById(refillId);
    }
}

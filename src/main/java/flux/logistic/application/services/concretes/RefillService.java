package flux.logistic.application.services.concretes;

import flux.logistic.application.requests.BranchRefillRequest;
import flux.logistic.application.dto.response.RefillResponse;
import flux.logistic.application.mappers.RefillMapper;
import flux.logistic.application.services.contracts.IRefillService;
import flux.logistic.domain.entities.Refill;
import flux.logistic.domain.repositories.IBranchRepository;
import flux.logistic.domain.repositories.IRefillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RefillService implements IRefillService{

    private final IRefillRepository refillRepository;
    private final IBranchRepository branchRepository;

    @Override
    public RefillResponse create(BranchRefillRequest create_refill) {
        Refill refill = refillRepository.save(RefillMapper.branchRequestToRefill(create_refill, branchRepository));
        return RefillMapper.mapRefilltoRefillResponse(refill);
    }

    @Override
    public RefillResponse getById(UUID refillId) {
        Refill refill = refillRepository.getById(refillId);
        RefillResponse refillResponse = RefillMapper.mapRefilltoRefillResponse(refill);
        return refillResponse;
    }


}

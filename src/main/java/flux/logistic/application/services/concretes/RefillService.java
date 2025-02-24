package flux.logistic.application.services.concretes;

import flux.logistic.application.dto.request.BranchRefillRequest;
import flux.logistic.application.dto.response.RefillResponse;
import flux.logistic.application.mappers.IRefillMapper;
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
    private final IRefillMapper refillMapper;

    @Override
    public RefillResponse create(BranchRefillRequest create_refill) {
        Refill refill = refillRepository.save(RefillMapper.branchRequestToRefill(create_refill, branchRepository));
        return new RefillResponse(refill.getRefillId(), 10, "Refill requested");
    }

    @Override
    public RefillResponse getById(UUID refillId) {
        Refill refill = refillRepository.getById(refillId);
        RefillResponse refillResponse = refillMapper.mapRefilltoRefillResponse(refill);
        return refillResponse;
    }


}

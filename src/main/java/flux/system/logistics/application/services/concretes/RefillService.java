package flux.system.logistics.application.services.concretes;

import flux.system.logistics.application.requests.BranchRefillRequest;
import flux.system.logistics.application.dto.response.RefillResponse;
import flux.system.logistics.application.mappers.RefillMapper;
import flux.system.logistics.application.services.contracts.IRefillService;
import flux.system.logistics.domain.entities.Refill;
import flux.logistic.domain.repositories.IBranchRepository;
import flux.system.logistics.domain.repositories.IRefillRepository;
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

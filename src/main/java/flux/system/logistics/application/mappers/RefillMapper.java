package flux.system.logistics.application.mappers;

import flux.system.logistics.application.requests.BranchRefillRequest;
import flux.system.logistics.application.dto.response.RefillResponse;
import flux.system.logistics.domain.entities.Branch;
import flux.system.logistics.domain.entities.Med;
import flux.system.logistics.domain.entities.Refill;
import flux.system.logistics.domain.repositories.IBranchRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RefillMapper {

    private static IBranchMapper branchMapper;

    public static Refill branchRequestToRefill(BranchRefillRequest refillRequest, IBranchRepository branchRepository) {
        Refill refill = new Refill();

        refill.setRefillTimestamp(refillRequest.getTimestamp());

        Branch branch = branchRepository.getById(refillRequest.getBranch_id());

        refill.setRefillBranch(branch);

        List<Med> meds = refillRequest.getRequested_meds().stream()
                .map(dtoMed -> new Med(dtoMed.getMed_name(), dtoMed.getMed_quantity()))
                .collect(Collectors.toList());

        refill.setRefillRequestedMed(meds);

        return refill;
    }

    public static RefillResponse mapRefilltoRefillResponse(Refill refill){
        return new RefillResponse(refill.getRefillId(), 10,"refill in the way");
    }

}

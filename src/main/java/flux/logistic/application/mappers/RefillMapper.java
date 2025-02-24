package flux.logistic.application.mappers;

import flux.logistic.application.dto.request.BranchRefillRequest;
import flux.logistic.application.services.concretes.BranchService;
import flux.logistic.domain.entities.Branch;
import flux.logistic.domain.entities.Med;
import flux.logistic.domain.entities.Refill;
import flux.logistic.domain.repositories.IBranchRepository;

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
}

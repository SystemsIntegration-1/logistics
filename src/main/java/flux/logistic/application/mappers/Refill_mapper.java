package flux.logistic.application.mappers;

import flux.logistic.application.dto.request.Branch_Refill_Request;
import flux.logistic.domain.entities.Branch;
import flux.logistic.domain.entities.Med;
import flux.logistic.domain.entities.Refill;

import java.util.List;
import java.util.stream.Collectors;

public class Refill_mapper {

    public static Refill branchRequestToRefill(Branch_Refill_Request refillRequest) {
        Refill refill = new Refill();

        refill.setRefillTimestamp(refillRequest.getTimestamp());

        Branch branch = getBranchById(refillRequest.getBranch_id());
        refill.setRefillBranch(branch);

        List<Med> meds = refillRequest.getRequested_meds().stream()
                .map(dtoMed -> new Med(dtoMed.getMed_name(), dtoMed.getMed_quantity()))
                .collect(Collectors.toList());

        refill.setRefillRequestedMed(meds);

        return refill;
    }
}

package flux.logistic.application.services.contracts;

import flux.logistic.application.responses.BranchResponse;
import flux.logistic.application.requests.BranchCreateRequest;
import flux.logistic.application.requests.BranchUpdateRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBranchService {
  Optional<BranchResponse> getBranchById(UUID branchId);
  List<BranchResponse> findAllBranches();
  BranchResponse createBranch(BranchCreateRequest branchCreateRequest);
  BranchResponse updateBranchById(UUID id, BranchUpdateRequest branchUpdateRequest);
  boolean deleteBranchById(UUID branchId);
}

package flux.system.logistics.application.services.contracts;

import flux.system.logistics.application.requests.BranchCreateRequest;
import flux.system.logistics.application.requests.BranchUpdateRequest;
import flux.system.logistics.application.responses.BranchResponse;
import flux.system.logistics.domain.entities.Branch;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBranchService {

  Optional<BranchResponse> getBranchById(UUID branchId);

  Optional<Branch> getBranchByName(String branchName);

  List<BranchResponse> findAllBranches();

  BranchResponse createBranch(BranchCreateRequest branchCreateRequest);

  BranchResponse updateBranchById(UUID id, BranchUpdateRequest branchUpdateRequest);

  boolean deleteBranchById(UUID branchId);
}

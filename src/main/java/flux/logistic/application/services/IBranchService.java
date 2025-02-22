package flux.logistic.application.services;

import flux.logistic.application.responses.BranchResponse;
import flux.logistic.application.requests.BranchCreateRequest;
import flux.logistic.application.requests.BranchUpdateRequest;
import flux.logistic.domain.entities.Branch;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBranchService {
  Optional<Branch> getBranchById(UUID id);
  List<Branch> findAllBranch();
  BranchResponse createBranch(BranchCreateRequest dto);
  BranchResponse updateBranchById(UUID id, BranchUpdateRequest dto);
  boolean deleteBranchById(UUID id);
}

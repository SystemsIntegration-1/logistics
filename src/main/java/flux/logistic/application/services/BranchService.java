package flux.logistic.application.services;

import flux.logistic.application.responses.BranchResponse;
import flux.logistic.application.requests.BranchCreateRequest;
import flux.logistic.application.requests.BranchUpdateRequest;
import flux.logistic.domain.entities.Branch;
import flux.logistic.domain.repositories.IBranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BranchService implements IBranchService {
  private IBranchRepository branchRepository;

  public BranchService(IBranchRepository branchRepository) {
    this.branchRepository = branchRepository;
  }

  @Override
  public Optional<Branch> getBranchById(UUID id) {
    return branchRepository.findById(id);
  }

  @Override
  public List<Branch> findAllBranch() {
    return branchRepository.findAll();
  }

  @Override
  public BranchResponse createBranch(BranchCreateRequest dto) {
    return null;
  }

  @Override
  public BranchResponse updateBranchById(UUID id, BranchUpdateRequest dto) {
    return null;
  }

  @Override
  public boolean deleteBranchById(UUID id) {
    return false;
  }
}

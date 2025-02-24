package flux.logistic.application.services.concretes;

import flux.logistic.application.mappers.IAddressMapper;
import flux.logistic.application.mappers.IBranchMapper;
import flux.logistic.application.mappers.IContactMapper;
import flux.logistic.application.responses.AddressResponse;
import flux.logistic.application.responses.BranchResponse;
import flux.logistic.application.requests.BranchCreateRequest;
import flux.logistic.application.requests.BranchUpdateRequest;
import flux.logistic.application.responses.ContactResponse;
import flux.logistic.application.services.contracts.IAddressService;
import flux.logistic.application.services.contracts.IBranchService;
import flux.logistic.application.services.contracts.IContactService;
import flux.logistic.domain.entities.Branch;
import flux.logistic.domain.repositories.IBranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BranchService implements IBranchService {
  private final IBranchRepository branchRepository;
  private final IAddressService addressService;
  private final IContactService contactService;
  private final IBranchMapper branchMapper;
  private final IAddressMapper addressMapper;
  private final IContactMapper contactMapper;

  public BranchService(IBranchRepository branchRepository,
                       IAddressService addressService,
                       IContactService contactService,
                       IBranchMapper branchMapper,
                       IAddressMapper addressMapper,
                       IContactMapper contactMapper) {
    this.branchRepository = branchRepository;
    this.addressService = addressService;
    this.contactService = contactService;
    this.branchMapper = branchMapper;
    this.addressMapper = addressMapper;
    this.contactMapper = contactMapper;
  }

  @Override
  public Optional<BranchResponse> getBranchById(UUID branchId) {
    return branchRepository
            .findById(branchId)
            .map(branchMapper::mapBranchToBranchResponse);
  }

  @Override
  public List<BranchResponse> findAllBranches() {
    List<Branch> branches = branchRepository.findAll();

    return branches
            .stream()
            .map(branchMapper::mapBranchToBranchResponse)
            .collect(Collectors.toList());
  }

  @Override
  public BranchResponse createBranch(BranchCreateRequest branchCreateRequest) {
    AddressResponse createdAddress = addressService.createAddress(branchCreateRequest.address());
    ContactResponse createdContact = contactService.createContact(branchCreateRequest.contact());

    Branch branch = branchMapper.mapBranchCreateRequestToBranch(branchCreateRequest);
    branch.setAddress(addressMapper.mapAddressResponseToAddress(createdAddress));
    branch.setContact(contactMapper.mapContactResponseToContact(createdContact));

    Branch createdBranch = branchRepository.save(branch);

    return branchMapper.mapBranchToBranchResponse(createdBranch);
  }

  @Override
  public BranchResponse updateBranchById(UUID id, BranchUpdateRequest branchUpdateRequest) {
    return null;
  }

  @Override
  public boolean deleteBranchById(UUID branchId) {
    return false;
  }
}

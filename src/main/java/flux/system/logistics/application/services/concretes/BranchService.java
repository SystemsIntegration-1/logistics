package flux.system.logistics.application.services.concretes;

import flux.system.logistics.application.mappers.IBranchMapper;
import flux.system.logistics.application.responses.BranchResponse;
import flux.system.logistics.application.requests.BranchCreateRequest;
import flux.system.logistics.application.requests.BranchUpdateRequest;
import flux.system.logistics.application.services.contracts.IAddressService;
import flux.system.logistics.application.services.contracts.IBranchService;
import flux.system.logistics.application.services.contracts.IContactService;
import flux.system.logistics.domain.entities.Address;
import flux.system.logistics.domain.entities.Branch;
import flux.system.logistics.domain.entities.Contact;
import flux.system.logistics.domain.repositories.IBranchRepository;

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

  public BranchService(IBranchRepository branchRepository,
                       IAddressService addressService,
                       IContactService contactService,
                       IBranchMapper branchMapper) {
    this.branchRepository = branchRepository;
    this.addressService = addressService;
    this.contactService = contactService;
    this.branchMapper = branchMapper;
  }

  @Override
  public Optional<BranchResponse> getBranchById(UUID branchId) {
    return branchRepository
            .findById(branchId)
            .map(branchMapper::mapEntityToBranchResponse);
  }

  @Override
  public Optional<Branch> getBranchByName(String branchName) {
    return branchRepository.findByBranchName(branchName);
  }

  @Override
  public List<BranchResponse> findAllBranches() {
    return branchRepository
            .findAll()
            .stream()
            .map(branchMapper::mapEntityToBranchResponse)
            .collect(Collectors.toList());
  }

  @Override
  public BranchResponse createBranch(BranchCreateRequest branchCreateRequest) {
    Address address = new Address();
    address.setCityName(branchCreateRequest.address().cityName());
    address.setCountryName(branchCreateRequest.address().countryName());
    address.setLatitude(branchCreateRequest.address().latitude());
    address.setLongitude(branchCreateRequest.address().longitude());

    Contact contact = new Contact();
    contact.setName(branchCreateRequest.contact().name());
    contact.setEmail(branchCreateRequest.contact().email());
    contact.setPhone(branchCreateRequest.contact().phone());

    Branch branch = new Branch();
    branch.setBranchName(branchCreateRequest.branchName());
    branch.setAddress(address);
    branch.setContact(contact);

    branchRepository.save(branch);

    return branchMapper.mapEntityToBranchResponse(branch);
  }

  @Override
  public BranchResponse updateBranchById(UUID branchId, BranchUpdateRequest branchUpdateRequest) {
    return branchRepository
            .findById(branchId)
            .map(branch -> {
              if (branchUpdateRequest.branchName() != null) {
                branch.setBranchName(branchUpdateRequest.branchName());
              }

              if (branchUpdateRequest.address() != null) {
                Address address = branch.getAddress();
                address.setCityName(branchUpdateRequest.address().cityName());
                address.setCountryName(branchUpdateRequest.address().countryName());
                address.setLatitude(branchUpdateRequest.address().latitude());
                address.setLongitude(branchUpdateRequest.address().longitude());
              }

              if (branchUpdateRequest.contact() != null) {
                Contact contact = branch.getContact();
                contact.setName(branchUpdateRequest.contact().name());
                contact.setEmail(branchUpdateRequest.contact().email());
                contact.setPhone(branchUpdateRequest.contact().phone());
              }

              branchRepository.save(branch);

              return branchMapper.mapEntityToBranchResponse(branch);
            })
            .orElseThrow(() -> new RuntimeException("Branch not found with id: " + branchId));
  }

  @Override
  public boolean deleteBranchById(UUID branchId) {
    return branchRepository
            .findById(branchId)
            .map(branch -> {
              addressService.deleteAddressById(branch.getAddress().getAddressId());
              contactService.deleteContactById(branch.getContact().getContactId());

              branchRepository.delete(branch);

              return true;
            })
            .orElse(false);
  }
}

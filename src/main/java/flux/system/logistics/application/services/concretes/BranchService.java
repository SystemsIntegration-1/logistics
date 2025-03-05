package flux.system.logistics.application.services.concretes;

import flux.system.logistics.application.mappers.IBranchMapper;
import flux.system.logistics.application.responses.BranchMedQueryResponse;
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

import flux.system.logistics.presentation.controllers.consumer.BranchApiConsumer;
import flux.system.logistics.presentation.controllers.consumer.GeolocationApiConsumer;
import org.springframework.stereotype.Service;

import java.util.*;
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

  @Override
  public Optional<List<Branch>> findClosestBranch(UUID branchId, UUID medId, int requiredAmount) {
    Optional<Branch> optional = branchRepository.findById(branchId);
    if (optional.isEmpty()){
      System.out.println("Unexpected error");
      return Optional.empty();
    }
    Branch origin = optional.get();

    List<Branch> branches = branchRepository.findAll();
    List<Branch> branchWithMedList = new ArrayList<>();

    BranchApiConsumer branchApiConsumer = new BranchApiConsumer();
    branches.forEach(b -> {
      // TODO: obtain branch's instance address from b
      BranchMedQueryResponse response = branchApiConsumer.medBranchQuery("http://localhost:5027/", medId);
      if (response.stock() >= requiredAmount){
        branchWithMedList.add(b);
      }
    });

    Map<Integer, Branch> distanceBranch = new HashMap<>();
    GeolocationApiConsumer geolocationApiConsumer = new GeolocationApiConsumer();
    branchWithMedList.forEach(b -> {
      int distance = geolocationApiConsumer.measureDistanceTwoPoints(origin.getAddress(), b.getAddress());
      distanceBranch.put(distance, b);
    });

    return Optional.of(distanceBranch.values().stream().toList());
  }
}

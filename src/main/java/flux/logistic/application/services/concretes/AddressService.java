package flux.logistic.application.services.concretes;

import flux.logistic.application.mappers.IAddressMapper;
import flux.logistic.application.requests.AddressCreateRequest;
import flux.logistic.application.requests.AddressUpdateRequest;
import flux.logistic.application.responses.AddressResponse;
import flux.logistic.application.services.contracts.IAddressService;
import flux.logistic.domain.entities.Address;
import flux.logistic.domain.repositories.IAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService implements IAddressService {
  private final IAddressRepository addressRepository;
  private final IAddressMapper addressMapper;

  public AddressService(IAddressRepository addressRepository,
                        IAddressMapper addressMapper) {
    this.addressRepository = addressRepository;
    this.addressMapper = addressMapper;
  }

  @Override
  public Optional<Address> findAddressById(UUID addressId) {
    return addressRepository.findById(addressId);
  }

  @Override
  public List<Address> findAllAddresses() {
    return addressRepository.findAll();
  }

  @Override
  public AddressResponse createAddress(AddressCreateRequest addressCreateRequest) {
    Address address = addressMapper.mapAddressCreateRequestToAddress(addressCreateRequest);

    Address createdAddress = addressRepository.save(address);

    return addressMapper.mapAddressToAddressResponse(createdAddress);
  }

  @Override
  public AddressResponse updateAddressById(UUID addressId, AddressUpdateRequest addressUpdateRequest) {
    return null;
  }

  @Override
  public boolean deleteAddressById(UUID addressId) {
    return false;
  }
}

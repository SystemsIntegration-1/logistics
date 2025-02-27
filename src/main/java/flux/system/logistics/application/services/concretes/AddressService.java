package flux.system.logistics.application.services.concretes;

import flux.system.logistics.application.mappers.IAddressMapper;
import flux.system.logistics.application.requests.AddressCreateRequest;
import flux.system.logistics.application.requests.AddressUpdateRequest;
import flux.system.logistics.application.responses.AddressResponse;
import flux.system.logistics.application.services.contracts.IAddressService;
import flux.system.logistics.domain.entities.Address;
import flux.system.logistics.domain.repositories.IAddressRepository;

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
  public Optional<Address> findAddressByCityName(String cityName) {
    return addressRepository.findByCityName(cityName);
  }

  @Override
  public List<Address> findAllAddresses() {
    return addressRepository.findAll();
  }

  @Override
  public AddressResponse createAddress(AddressCreateRequest addressCreateRequest) {
    Address address = new Address();
    address.setCityName(addressCreateRequest.cityName());
    address.setCountryName(addressCreateRequest.countryName());
    address.setLatitude(addressCreateRequest.latitude());
    address.setLongitude(addressCreateRequest.longitude());
    addressRepository.save(address);

    return addressMapper.mapAddressToAddressResponse(address);
  }

  @Override
  public AddressResponse updateAddressById(UUID addressId, AddressUpdateRequest addressUpdateRequest) {
    return addressRepository.findById(addressId)
            .map(address -> {
              if (addressUpdateRequest.cityName() != null) {
                address.setCityName(addressUpdateRequest.cityName());
              }
              if (addressUpdateRequest.countryName() != null) {
                address.setCountryName(addressUpdateRequest.countryName());
              }
              if (addressUpdateRequest.latitude() != null) {
                address.setLatitude(addressUpdateRequest.latitude());
              }
              if (addressUpdateRequest.longitude() != null) {
                address.setLongitude(addressUpdateRequest.longitude());
              }

              addressRepository.save(address);

              return addressMapper.mapAddressToAddressResponse(address);
            })
            .orElseThrow(() -> new RuntimeException("Address not found with id: " + addressId));
  }

  @Override
  public boolean deleteAddressById(UUID addressId) {
    return addressRepository
            .findById(addressId)
            .map(address -> {
              addressRepository.delete(address);

              return true;
            })
            .orElse(false);
  }
}

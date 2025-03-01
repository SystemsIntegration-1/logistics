package flux.system.logistics.application.services.contracts;

import flux.system.logistics.application.requests.AddressCreateRequest;
import flux.system.logistics.application.requests.AddressUpdateRequest;
import flux.system.logistics.application.responses.AddressResponse;
import flux.system.logistics.domain.entities.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IAddressService {

  Optional<Address> findAddressById(UUID addressId);

  Optional<Address> findAddressByCityName(String cityName);

  List<Address> findAllAddresses();

  AddressResponse createAddress(AddressCreateRequest addressCreateRequest);

  AddressResponse updateAddressById(UUID addressId, AddressUpdateRequest addressUpdateRequest);

  boolean deleteAddressById(UUID addressId);
}

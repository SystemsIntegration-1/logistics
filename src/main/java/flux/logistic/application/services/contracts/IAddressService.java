package flux.logistic.application.services.contracts;

import flux.logistic.application.requests.AddressCreateRequest;
import flux.logistic.application.requests.AddressUpdateRequest;
import flux.logistic.application.responses.AddressResponse;
import flux.logistic.domain.entities.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IAddressService {
  Optional<Address> findAddressById(UUID addressId);
  List<Address> findAllAddresses();
  AddressResponse createAddress(AddressCreateRequest addressCreateRequest);
  AddressResponse updateAddressById(UUID addressId, AddressUpdateRequest addressUpdateRequest);
  boolean deleteAddressById(UUID addressId);
}

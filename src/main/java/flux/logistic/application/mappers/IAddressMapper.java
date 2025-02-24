package flux.logistic.application.mappers;

import flux.logistic.application.requests.AddressCreateRequest;
import flux.logistic.application.responses.AddressResponse;
import flux.logistic.domain.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IAddressMapper {
  IAddressMapper INSTANCE = Mappers.getMapper(IAddressMapper.class);

  @Mapping(target = "addressId", ignore = true)
  Address mapAddressCreateRequestToAddress(AddressCreateRequest addressCreateRequest);

  AddressCreateRequest mapAddressToAddressCreateRequest(Address address);

  Address mapAddressResponseToAddress(AddressResponse addressResponse);

  AddressResponse mapAddressToAddressResponse(Address address);
}

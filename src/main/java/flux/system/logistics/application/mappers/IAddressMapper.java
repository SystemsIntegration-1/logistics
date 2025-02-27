package flux.system.logistics.application.mappers;

import flux.system.logistics.application.responses.AddressResponse;
import flux.system.logistics.domain.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IAddressMapper {

  IAddressMapper INSTANCE = Mappers.getMapper(IAddressMapper.class);

  Address mapAddressResponseToAddress(AddressResponse addressResponse);

  AddressResponse mapAddressToAddressResponse(Address address);
}

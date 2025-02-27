package flux.system.logistics.application.mappers;

import flux.system.logistics.application.responses.ContactResponse;
import flux.system.logistics.domain.entities.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IContactMapper {

  IContactMapper INSTANCE = Mappers.getMapper(IContactMapper.class);

  Contact mapContactResponseToContact(ContactResponse contactResponse);

  ContactResponse mapContactToContactResponse(Contact contact);
}

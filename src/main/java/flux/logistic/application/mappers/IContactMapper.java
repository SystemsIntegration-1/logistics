package flux.logistic.application.mappers;

import flux.logistic.application.requests.ContactCreateRequest;
import flux.logistic.application.responses.ContactResponse;
import flux.logistic.domain.entities.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IContactMapper {
  IContactMapper INSTANCE = Mappers.getMapper(IContactMapper.class);

  @Mapping(target = "contactId", ignore = true)
  Contact mapContactCreateRequestToContact(ContactCreateRequest contactCreateRequest);

  ContactCreateRequest mapContactToContactCreateRequest(Contact contact);

  Contact mapContactResponseToContact(ContactResponse contactResponse);

  ContactResponse mapContactToContactResponse(Contact contact);
}

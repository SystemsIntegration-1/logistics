package flux.logistic.application.services.contracts;

import flux.logistic.application.requests.ContactCreateRequest;
import flux.logistic.application.requests.ContactUpdateRequest;
import flux.logistic.application.responses.ContactResponse;
import flux.logistic.domain.entities.Contact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IContactService {
  Optional<Contact> findContactById(UUID contactId);
  List<Contact> findAllContacts();
  ContactResponse createContact(ContactCreateRequest contactCreateRequest);
  ContactResponse updateContactById(UUID contactId, ContactUpdateRequest contactUpdateRequest);
  boolean deleteContactById(UUID contactId);
}

package flux.system.logistics.application.services;

import flux.system.logistics.application.requests.ContactCreateRequest;
import flux.system.logistics.application.requests.ContactUpdateRequest;
import flux.system.logistics.application.responses.ContactResponse;
import flux.system.logistics.domain.entities.Contact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IContactService {

  Optional<Contact> findContactById(UUID contactId);

  Optional<Contact> findContactByEmail(String email);

  List<Contact> findAllContacts();

  ContactResponse createContact(ContactCreateRequest contactCreateRequest);

  ContactResponse updateContactById(UUID contactId, ContactUpdateRequest contactUpdateRequest);

  boolean deleteContactById(UUID contactId);
}

package flux.logistic.application.services.concretes;

import flux.logistic.application.mappers.IContactMapper;
import flux.logistic.application.requests.ContactCreateRequest;
import flux.logistic.application.requests.ContactUpdateRequest;
import flux.logistic.application.responses.ContactResponse;
import flux.logistic.application.services.contracts.IContactService;
import flux.logistic.domain.entities.Contact;
import flux.logistic.domain.repositories.IContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactService implements IContactService {
  private final IContactRepository contactRepository;
  private final IContactMapper contactMapper;

  public ContactService(IContactRepository contactRepository,
                        IContactMapper contactMapper) {
    this.contactRepository = contactRepository;
    this.contactMapper = contactMapper;
  }

  @Override
  public Optional<Contact> findContactById(UUID contactId) {
    return contactRepository.findById(contactId);
  }

  @Override
  public List<Contact> findAllContacts() {
    return contactRepository.findAll();
  }

  @Override
  public ContactResponse createContact(ContactCreateRequest contactCreateRequest) {
    Contact contact = contactMapper.mapContactCreateRequestToContact(contactCreateRequest);

    Contact createdContact = contactRepository.save(contact);

    return contactMapper.mapContactToContactResponse(createdContact);
  }

  @Override
  public ContactResponse updateContactById(UUID contactId, ContactUpdateRequest contactUpdateRequest) {
    return null;
  }

  @Override
  public boolean deleteContactById(UUID contactId) {
    return false;
  }
}

package flux.system.logistics.application.services;

import flux.system.logistics.application.mappers.IContactMapper;
import flux.system.logistics.application.requests.ContactCreateRequest;
import flux.system.logistics.application.requests.ContactUpdateRequest;
import flux.system.logistics.application.responses.ContactResponse;
import flux.system.logistics.domain.entities.Contact;
import flux.system.logistics.domain.repositories.IContactRepository;

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
  public Optional<Contact> findContactByEmail(String email) {
    return contactRepository.findByEmail(email);
  }

  @Override
  public List<Contact> findAllContacts() {
    return contactRepository.findAll();
  }

  @Override
  public ContactResponse createContact(ContactCreateRequest contactCreateRequest) {
    Contact contact = new Contact();
    contact.setName(contactCreateRequest.name());
    contact.setEmail(contactCreateRequest.email());
    contact.setPhone(contactCreateRequest.phone());
    contactRepository.save(contact);

    return contactMapper.mapContactToContactResponse(contact);
  }

  @Override
  public ContactResponse updateContactById(UUID contactId, ContactUpdateRequest contactUpdateRequest) {
    return contactRepository
            .findById(contactId)
            .map(contact -> {
              if (contactUpdateRequest.name() != null) {
                contact.setName(contactUpdateRequest.name());
              }
              if (contactUpdateRequest.email() != null) {
                contact.setEmail(contactUpdateRequest.email());
              }
              if (contactUpdateRequest.phone() != null) {
                contact.setPhone(contactUpdateRequest.phone());
              }

              contactRepository.save(contact);

              return contactMapper.mapContactToContactResponse(contact);
            })
            .orElseThrow(() -> new RuntimeException("Contact not found with id: " + contactId));
  }

  @Override
  public boolean deleteContactById(UUID contactId) {
    return contactRepository
            .findById(contactId)
            .map(contact -> {
              contactRepository.delete(contact);

              return true;
            })
            .orElse(false);
  }
}

package flux.system.logistics.domain.repositories;

import flux.system.logistics.domain.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IContactRepository extends JpaRepository<Contact, UUID> {

  Optional<Contact> findByEmail(String email);
}

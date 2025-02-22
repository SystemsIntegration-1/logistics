package flux.logistic.domain.repositories;

import flux.logistic.domain.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IContactRepository extends JpaRepository<Contact, UUID> {
}

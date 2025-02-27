package flux.system.logistics.domain.repositories;

import flux.system.logistics.domain.entities.Refill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IRefillRepository extends JpaRepository<Refill, UUID> {
}

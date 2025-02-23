package flux.logistic.domain.repositories;

import flux.logistic.domain.entities.Refill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IRefillRepository extends JpaRepository<Refill, UUID> {
}

package flux.system.logistics.domain.repositories;

import flux.system.logistics.domain.entities.RefillOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRefillOrderRepository extends JpaRepository<RefillOrder, UUID> {
}

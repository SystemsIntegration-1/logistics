package flux.system.logistics.domain.repositories;

import flux.system.logistics.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IAddressRepository extends JpaRepository<Address, UUID> {

  Optional<Address> findByCityName(String cityName);
}

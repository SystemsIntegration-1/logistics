package flux.system.logistics.domain.repositories;

import flux.system.logistics.domain.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, UUID> {

  Optional<Branch> findByBranchName(String branchName);
}

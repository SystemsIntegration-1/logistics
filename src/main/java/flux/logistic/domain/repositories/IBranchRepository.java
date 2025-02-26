package flux.logistic.domain.repositories;

import flux.logistic.domain.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, UUID> {
}

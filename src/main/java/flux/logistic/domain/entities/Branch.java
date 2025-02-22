package flux.logistic.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "branch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "branch_id", nullable = false, updatable = false)
  private UUID branchId;

  @Column(name = "branch_name")
  private String branchName;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "address_id")
  private Address address;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
  private Contact contact;

  @ManyToOne()
  @JoinColumn(name = "refill_id")
  private Refill refill;
}

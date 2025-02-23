package flux.logistic.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "refill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Refill {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "refill_id")
  private UUID refillId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "branch_id")
  private Branch refillBranch;

  @ManyToMany
  @JoinTable(
          name = "refill_med",
          joinColumns = @JoinColumn(name = "refill_id"),
          inverseJoinColumns = @JoinColumn(name = "med_id")
  )
  private List<Med> refillRequestedMed;

  @Column(name = "refill_timestamp")
  private Date refillTimestamp;
}

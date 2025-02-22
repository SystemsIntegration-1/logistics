package flux.logistic.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  @OneToMany(mappedBy = "refill", cascade = CascadeType.ALL)
  @JsonIgnore()
  private List<Branch> branches;

  @ManyToOne(fetch = FetchType.LAZY)
  @Column
  private Med med;
}

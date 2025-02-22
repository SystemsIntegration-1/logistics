package flux.logistic.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "meds")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Med {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID medId;

  @Column
  private String name;
  @Column
  private String description;
  @Column
  private String category;

}

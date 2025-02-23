package flux.logistic.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "medication")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Med {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID medId;

  @Column(name = "medication_name")
  private String name;

  @Column(name = "medication_quantity")
  private int quantity;

  public Med(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }
}

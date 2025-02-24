package flux.logistic.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "contact")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "contact_id", nullable = false, updatable = false)
  private UUID contactId;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "phone")
  private String phone;

  @OneToOne(mappedBy = "contact")
  private Branch branch;
}

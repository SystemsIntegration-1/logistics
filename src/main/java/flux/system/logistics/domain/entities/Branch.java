package flux.system.logistics.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
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

  @Column(name = "branch_name", nullable = false)
  private String branchName;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "address_id", referencedColumnName = "address_id")
  @JsonIgnore()
  private Address address;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
  @JsonIgnore()
  private Contact contact;
}

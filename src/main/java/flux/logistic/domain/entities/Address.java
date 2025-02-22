package flux.logistic.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "address_id", nullable = false, updatable = false)
  private UUID addressId;

  @Column(name = "city_name")
  private String cityName;

  @Column(name = "country_name")
  private String countryName;

  @Column(name = "latitude")
  private BigDecimal latitude;

  @Column(name = "longitude")
  private BigDecimal longitude;

  @OneToOne(mappedBy = "address")
  private Branch branch;
}

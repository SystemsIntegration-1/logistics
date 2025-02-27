package flux.system.logistics.domain.entities;

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

  @Column(name = "city_name", nullable = false)
  private String cityName;

  @Column(name = "country_name", nullable = false)
  private String countryName;

  @Column(name = "latitude", precision = 9, scale = 6)
  private BigDecimal latitude;

  @Column(name = "longitude", precision = 9, scale = 6)
  private BigDecimal longitude;

  @OneToOne(mappedBy = "address")
  private Branch branch;
}

package flux.system.logistics.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "item_id", nullable = false, updatable = false)
  private UUID itemId;

  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  private RefillOrder refillOrder;

  @Column(name = "product_id", nullable = false)
  private UUID productId;

  @Column(name = "product_name", nullable = false)
  private String productName;

  @Column(name = "product_description")
  private String productDescription;

  @Column(name = "quantity", nullable = false)
  private int quantity;

  @Column(name = "notes")
  private String notes;
}

package co.com.bancolombia.r2dbc.repositories.product.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("products")
public class ProductEntity {

    @Id
    private Integer id;
    private String name;
    @Column(value = "ininventory")
    private Integer inInventory;
    private boolean enabled;
    private Integer min;
    private Integer max;
}

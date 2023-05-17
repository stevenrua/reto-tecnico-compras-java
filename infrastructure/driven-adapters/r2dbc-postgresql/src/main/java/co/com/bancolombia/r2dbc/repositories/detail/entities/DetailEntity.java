package co.com.bancolombia.r2dbc.repositories.detail.entities;

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
@Table("detail")
public class DetailEntity {
    @Id
    private Integer id;
    @Column(value = "buyid")
    private Integer buyId;
    @Column(value = "productid")
    private Integer productId;
    private Integer quantity;
}

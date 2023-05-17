package co.com.bancolombia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailsBuy {
    private Integer id;
    private Integer buyId;
    private Integer productId;
    private Integer quantity;
}

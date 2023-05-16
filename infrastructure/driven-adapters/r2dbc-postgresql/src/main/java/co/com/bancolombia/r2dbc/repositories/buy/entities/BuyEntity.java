package co.com.bancolombia.r2dbc.repositories.buy.entities;

import co.com.bancolombia.model.dto.compraDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("buys")
public class BuyEntity {
    @Id
    private Integer id;
    private Integer identity;
    private Date date;
    @Column(value = "idtype")
    private String idType;
    @Column(value = "clientname")
    private String clientName;
    private List<compraDTO> productos;
}

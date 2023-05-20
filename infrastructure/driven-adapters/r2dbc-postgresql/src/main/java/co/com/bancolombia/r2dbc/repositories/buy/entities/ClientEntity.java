package co.com.bancolombia.r2dbc.repositories.buy.entities;

import co.com.bancolombia.model.dto.compraDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("buys")
public class ClientEntity {
    @Id
    private Integer id;
    private Integer identity;
    private LocalDateTime date;
    @Column(value = "idtype")
    private String idType;
    @Column(value = "clientname")
    private String clientName;
    //private List<compraDTO> productos;
}

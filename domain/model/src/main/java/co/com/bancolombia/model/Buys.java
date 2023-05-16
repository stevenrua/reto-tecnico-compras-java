package co.com.bancolombia.model;

import co.com.bancolombia.model.dto.compraDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Buys {
    private Integer id;
    private Integer identity;
    private Date date;
    private String idType;
    private String clientName;
    private List<compraDTO> productos;
}

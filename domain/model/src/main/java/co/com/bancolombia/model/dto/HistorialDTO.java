package co.com.bancolombia.model.dto;

import co.com.bancolombia.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistorialDTO {
    private Client client;
    private List<ProductResponse> products;
}

package webshop.shopping.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@Getter
public class ProductDTO {
    private Long productNumber;

    private String description;
    private double price;

}

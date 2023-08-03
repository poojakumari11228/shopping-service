package webshop.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@AllArgsConstructor
@Getter
public class CartLineDTO {

    private Long quantity;
    private ProductDTO productDto;
}

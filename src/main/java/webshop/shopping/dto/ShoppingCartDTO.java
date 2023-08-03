package webshop.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShoppingCartDTO {

    private Long shoppingCartNumber;

    private List<CartLineDTO> cartLinesDto;



}

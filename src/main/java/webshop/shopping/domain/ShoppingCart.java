package webshop.shopping.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder
@AllArgsConstructor
@Getter
public class ShoppingCart {

    @Id
    private Long shoppingCartNumber;

    private List<CartLine> cartLines;



}

package webshop.shopping.mapper;

import webshop.shopping.domain.CartLine;
import webshop.shopping.domain.Product;
import webshop.shopping.domain.ShoppingCart;
import webshop.shopping.dto.CartLineDTO;
import webshop.shopping.dto.ProductDTO;
import webshop.shopping.dto.ShoppingCartDTO;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartMapper {

    public static ShoppingCartDTO shoppingCartToShoppingCartDTO(ShoppingCart shoppingCart) {

        return new ShoppingCartDTO(shoppingCart.getShoppingCartNumber(), listCartLinesToCartLinesDto(shoppingCart.getCartLines()));
    }


    public static List<CartLineDTO> listCartLinesToCartLinesDto(List<CartLine> cartLineList) {
        List<CartLineDTO> cartLinesDto = new ArrayList<>();

        cartLineList.stream().forEach(line -> {
            cartLinesDto.add(CartLineDTO.builder().productDto(ProductDTO.builder().productNumber(line.getProduct().getProductNumber()).description(line.getProduct().getDescription()).price(line.getProduct().getPrice()).build()).quantity(line.getQuantity()).build());
        });
        return cartLinesDto;
    }

/*    public static List<CartLine> listCartLinesDtoToCartLines(List<CartLineDTO> cartLineDtoList) {
        List<CartLine> cartLines = new ArrayList<>();

        cartLineDtoList.stream().forEach(line -> {
            cartLines.add(CartLine.builder().product(Product.builder().productNumber(line.getProductDto().getProductNumber()).description(line.getProductDto().getDescription()).price(line.getProductDto().getPrice()).build()).quantity(line.getQuantity()).build());
        });
        return cartLines;
    }*/
}

package webshop.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.shopping.domain.CartLine;
import webshop.shopping.domain.Product;
import webshop.shopping.domain.ShoppingCart;
import webshop.shopping.dto.CartLineDTO;
import webshop.shopping.dto.ShoppingCartDTO;
import webshop.shopping.mapper.ShoppingCartMapper;
import webshop.shopping.repository.ShoppingCartRepo;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ShoppingService {

    private ShoppingCartRepo shoppingCartRepo;

    @Autowired
    ShoppingService(ShoppingCartRepo shoppingCartRepo) {
        this.shoppingCartRepo = shoppingCartRepo;
    }

    public void addProductToCart(Long id, CartLineDTO cartLineDTO) {

        Optional<ShoppingCart> shoppingCartExists = shoppingCartRepo.findByShoppingCartNumber(id);

        CartLine newProductCartLine = CartLine.builder()
                .product(
                        Product.builder()
                                .productNumber(cartLineDTO.getProductDto().getProductNumber())
                                .description(cartLineDTO.getProductDto().getDescription())
                                .price(cartLineDTO.getProductDto().getPrice())
                                .build()
                )
                .quantity(cartLineDTO.getQuantity())
                .build();

        if (shoppingCartExists.isPresent()) {

            if (shoppingCartExists.get().getCartLines().isEmpty())
                shoppingCartExists.get().setCartLines(new ArrayList<>());

            shoppingCartExists.get().getCartLines().add(newProductCartLine);
            shoppingCartRepo.save(shoppingCartExists.get());
        } else {
            ShoppingCart shoppingCart = ShoppingCart.builder().shoppingCartNumber(1L).cartLines(new ArrayList<>()).build();
            shoppingCart.getCartLines().add(newProductCartLine);
            shoppingCartRepo.save(shoppingCart);
        }
    }

    public ShoppingCartDTO getShoppingCart(Long id) {

        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        Optional<ShoppingCart> shoppingCart = shoppingCartRepo.findByShoppingCartNumber(id);
        if (shoppingCart.isPresent()) {
            shoppingCartDTO = ShoppingCartMapper.shoppingCartToShoppingCartDTO(shoppingCart.get());
        }
        return shoppingCartDTO;
    }

}

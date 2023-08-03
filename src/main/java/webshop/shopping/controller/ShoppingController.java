package webshop.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webshop.shopping.dto.CartLineDTO;
import webshop.shopping.dto.ProductDTO;
import webshop.shopping.dto.ShoppingCartDTO;
import webshop.shopping.service.ShoppingService;

@RestController
@RequestMapping("/api/v1/shopping")
public class ShoppingController {

    private ShoppingService shoppingService;

    @Autowired
    ShoppingController(ShoppingService shoppingService){
        this.shoppingService = shoppingService;
    }

    @PostMapping("/addProduct/{id}")
    public void addProductToCart(@PathVariable("id") Long id , @RequestBody CartLineDTO cartLineDTO){
        shoppingService.addProductToCart(id, cartLineDTO);
    }

    @GetMapping("/{id}")
    public ShoppingCartDTO getShoppingCart(@PathVariable("id") Long id){
        return shoppingService.getShoppingCart(id);
    }
}

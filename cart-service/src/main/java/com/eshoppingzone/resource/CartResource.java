package com.eshoppingzone.resource;

import com.eshoppingzone.entity.Cart;
import com.eshoppingzone.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
@CrossOrigin
public class CartResource {

    @Autowired
    private CartService cartService;

    @GetMapping("/allCarts")
    public ResponseEntity<List<Cart>> getAllCarts() {
        return new ResponseEntity<>(cartService.getAllCarts() , HttpStatus.OK);
    }

    @PostMapping("/addCart/{cartId}")
    public void addNewCart(@PathVariable("cartId") int cartId) {
        Cart cart = new Cart();
        cart.setCartId(cartId);
        cartService.addCart(cart);
    }

    @GetMapping("/getCart/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable("cartId") int cartId) {
        Cart cart = cartService.getCartById(cartId);
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cart , HttpStatus.FOUND);
    }

    @PutMapping("/updateCart")
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
        return new ResponseEntity<>(cartService.updateCart(cart) , HttpStatus.OK);
    }
}

package com.eshoppingzone.Testing;

import com.eshoppingzone.entity.Cart;
import com.eshoppingzone.entity.Items;
import com.eshoppingzone.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartServiceTest {

    @Autowired
    private CartService cartService;

    private Items item;
    private List<Items> items;
    private Object NoSuchElementException;

    @BeforeEach
    public void setUp() {
        item = new Items("iPhone10" , 49000 , 10);
        items = new ArrayList<>();
        items.add(item);

        Cart cart = new Cart(1001 , items);
        cart.setTotalPrice(cartService.cartTotal(cart));
        cartService.addCart(cart);
    }

    @Test
    public void getCartByIdTest() throws Exception {
        Cart found = cartService.getCartById(1001);
        Cart expected = new Cart(100 , items);
        assertEquals(expected.getItems() , found.getItems());
    }

    @Test
    public void getCartWhenCartNotAvailable() throws Exception {
        Cart found = cartService.getCartById(1002);
        assertThrows(NoSuchElementException.class , () -> {
            Optional.ofNullable(found).get();
        });
    }

    @Test
    public void updateCartTest() throws Exception {
        Items newItem = new Items("iPhone12" , 69000.0 , 4);
        List<Items> newListItem = new ArrayList<>();
        newListItem.add(newItem);
        Cart found = cartService.getCartById(1001);
        found.setItems(newListItem);
        Cart updateCart = cartService.updateCart(found);
        assertEquals(found.getItems(), updateCart.getItems());
    }

    @Test
    public void getAllCartTest() {
        List<Cart> found = cartService.getAllCarts();
        assertEquals(4 , found.size());
    }
}

package com.tekone.tekone.service;

import com.tekone.tekone.domain.Product;
import com.tekone.tekone.domain.CartItem;
import com.tekone.tekone.domain.ShoppingCart;
import com.tekone.tekone.domain.User;


public interface ShoppingCartService {

	ShoppingCart getShoppingCart(User user);
	
	int getItemsNumber(User user);
	
	CartItem findCartItemById(Long cartItemId);
	
	CartItem addProductToShoppingCart(Product article, User user, int qty);
		
	void clearShoppingCart(User user);
	
	void updateCartItem(CartItem cartItem, Integer qty);

	void removeCartItem(CartItem cartItem);
	
}

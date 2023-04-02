package com.tekone.tekone.service;

import java.util.List;

import com.tekone.tekone.domain.Order;
import com.tekone.tekone.domain.Payment;
import com.tekone.tekone.domain.Shipping;
import com.tekone.tekone.domain.ShoppingCart;
import com.tekone.tekone.domain.User;

public interface OrderService {

	Order createOrder(ShoppingCart shoppingCart, Shipping shippingAddress, Payment payment, User user);
	
	List<Order> findByUser(User user);
	
	Order findOrderWithDetails(Long id);
}

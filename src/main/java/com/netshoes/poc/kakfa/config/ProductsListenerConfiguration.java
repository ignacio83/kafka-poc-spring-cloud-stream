package com.netshoes.poc.kakfa.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import com.netshoes.poc.kakfa.domain.Product;

@EnableBinding(Products.class)
public class ProductsListenerConfiguration {

	@StreamListener(Products.INBOUND)
	@SendTo(Products.NETSHOES_PRODUCTS)
	public Product process(Product product) {
		System.out.println(product.getSku() + " " + product.getName());
		product.setProcessed(true);
		return product;
	}

	@StreamListener(Products.NETSHOES_PRODUCTS)
	public void netshoesProducts(Product product) {
		System.out.println(product.getSku() + " " + product.getName() + " " + product.isProcessed());
	}
}

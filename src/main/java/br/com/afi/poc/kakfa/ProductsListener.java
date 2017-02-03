package br.com.afi.poc.kakfa;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import br.com.afi.poc.kakfa.config.Products;
import br.com.afi.poc.kakfa.domain.Product;

@EnableBinding(Products.class)
public class ProductsListener {

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

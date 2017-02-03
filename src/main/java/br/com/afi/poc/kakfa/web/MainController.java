package br.com.afi.poc.kakfa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.afi.poc.kakfa.config.Products;
import br.com.afi.poc.kakfa.domain.Product;

@RestController
public class MainController {
	private static int sku = 0;
	private Products products;

	@Autowired
	public MainController(Products products) {
		this.products = products;
	}

	@PostMapping("/sendMessage")
	public void sendMessage() {
		Product product = new Product();
		product.setName("Teste");
		product.setSku(String.valueOf(sku++));

		products.inbound().send(MessageBuilder.withPayload(product).build());
	}
}

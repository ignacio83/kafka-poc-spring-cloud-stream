package com.netshoes.poc.kakfa.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Products {
	String INBOUND = "inbound";
	String NETSHOES_PRODUCTS = "netshoesProducts";
	
	@Input
	SubscribableChannel inbound();

	@Input
	@Output
	MessageChannel netshoesProducts();

	@Output
	MessageChannel marketplaceProducts();
}

package de.hirthe.ms.consumer;

import de.hirthe.ms.consumer.ProductConsumer.ProductConsumerService;
import de.hirthe.ms.consumer.ProductConsumer.ProductConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ConsumerApplication {

	@Autowired
	private ProductConsumerServiceImpl t;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
		new ConsumerApplication().askProduct();
	}

	public void askProduct() {
		new ProductConsumerServiceImpl().getProductData();

	}


}

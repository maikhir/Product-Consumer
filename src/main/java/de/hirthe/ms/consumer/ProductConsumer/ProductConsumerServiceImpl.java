package de.hirthe.ms.consumer.ProductConsumer;

import de.hirthe.ms.consumer.model.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductConsumerServiceImpl implements ProductConsumerService {

    private final WebClient webProductClient;


    public ProductConsumerServiceImpl() {
        this.webProductClient = WebClient
                .builder()
                .baseUrl("http://product.hirthe.ddnss.de/api/product")
                .defaultHeaders(header -> header.setBasicAuth("maik", "maik13"))
                .build();
        this.webProductClient.method(HttpMethod.GET);
    }

    public void getProductData() {
        Mono<List<Product>> response = webProductClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Product>>() {});
        List<Product> products = response.block(Duration.ofSeconds(1));
        System.out.println(Arrays.toString(products.toArray()));
    }
}

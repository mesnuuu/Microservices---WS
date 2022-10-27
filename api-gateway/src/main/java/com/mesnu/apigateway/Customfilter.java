package com.mesnu.apigateway;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;


import reactor.core.publisher.Mono;

@Configuration
public class Customfilter implements GlobalFilter{

    Logger logger = LoggerFactory.getLogger(Customfilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

       

        ServerHttpRequest request = exchange.getRequest();

		// Pre filter

		if (request.getURI().toString().contains("/api/student/")) {
			// any logic 
		}

		// Pre Filter
		logger.info("Authorization = " + request.getHeaders().getFirst("Authorization"));

		// response and then post filter

		return chain.filter(exchange)
				.then(Mono.fromRunnable(() -> {
					ServerHttpResponse response = exchange.getResponse();
					logger.info("Post Filter = " + response.getStatusCode());
				}));
	}
}

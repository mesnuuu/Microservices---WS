package com.mesnu.apigateway;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;


import reactor.core.publisher.Mono;

@Configuration
public class Customfilter implements GlobalFilter{

    Logger logger = LoggerFactory.getLogger(Customfilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // TODO Auto-generated method stub

        ServerHttpRequest request = exchange.getRequest();

        logger.info("Authorization = " + request.getHeaders().getFirst("Authorization"));

        return chain.filter(exchange);
    }

    
    
}

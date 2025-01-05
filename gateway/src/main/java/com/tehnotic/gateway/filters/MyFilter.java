package com.tehnotic.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

@Component
public class MyFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Filter executed...");

        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();

        Set<String> keySet = headers.keySet();

        if(!keySet.contains("Secret")){
            throw  new RuntimeException("Invalid Request");
        }
        else {
            List<String> secret = headers.get("Secret");
            if ((!secret.get(0).equals("admin"))){
                throw  new RuntimeException("Invalid Request");
            }
            else {
                return chain.filter(exchange);
            }
        }


    }
}

package org.github.caishijun.webflux.controller;

import org.github.caishijun.webflux.utils.HttpClientUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;


@RestController
public class WebfluxController {

    /**
     * 1、WebFlux 基于WebMVC注解的方式
     */
    @GetMapping("/mvcWebFlux")
    public Mono<String> mvcWebFlux() throws Exception {   // 【改】返回类型为Mono<String>
        Thread.sleep(500);
        return Mono.just("mvcWebFlux : Welcome to reactive world ~");     // 【改】使用Mono.just生成响应式数据
    }

    /**
     * 5、WebFlux 基于WebMVC注解的方式-跨应用测试
     */
    @GetMapping("/mvcWebFluxAcrossApplication")
    public Mono<String> mvcWebFluxAcrossApplication() {   // 【改】返回类型为Mono<String>
        String response = HttpClientUtils.sendGetRequest(HttpClientUtils.getUrl("/mvcWebFlux"));
        return Mono.just("mvcWebFluxAcrossApplication : " + response);     // 【改】使用Mono.just生成响应式数据
    }

    /**
     * 6、WebClient 简单调用
     */
    @GetMapping("/webClient")
    public Flux<String> webClient() {
        String baseUrl = "http://localhost:8080";
        WebClient webClient = WebClient.create(baseUrl);
        Flux<String> userFlux = webClient.get().uri("mvcWebFlux").retrieve().bodyToFlux(String.class);
        return userFlux;
    }

    /**
     * 7、WebSocket 简单调用
     */
    @GetMapping("/webSocket")
    public Mono<Void> webSocket() {
        final WebSocketClient client = new ReactorNettyWebSocketClient();
        Mono<Void> mono = client.execute(URI.create("ws://localhost:8080/echo"), session ->
            session.send(Flux.just(session.textMessage("你好")))
                .thenMany(session.receive().take(1).map(WebSocketMessage::getPayloadAsText))
                .doOnNext(System.out::println)
                .then());
        return mono;
    }
}




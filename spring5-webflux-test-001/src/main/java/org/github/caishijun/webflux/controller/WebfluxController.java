package org.github.caishijun.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 1、WebFlux 基于WebMVC注解的方式
 */
@RestController
public class WebfluxController {

    @GetMapping("/mvcWebFlux")
    public Mono<String> mvcWebFlux() {   // 【改】返回类型为Mono<String>
        return Mono.just("Welcome to reactive world ~");     // 【改】使用Mono.just生成响应式数据
    }
}




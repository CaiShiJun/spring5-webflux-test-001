package org.github.caishijun.webflux.controller;

import org.github.caishijun.webflux.utils.HttpClientUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class WebfluxController {

    /**
     * 1、WebFlux 基于WebMVC注解的方式
     */
    @GetMapping("/mvcWebFlux")
    public Mono<String> mvcWebFlux() {   // 【改】返回类型为Mono<String>
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
}




package org.github.caishijun.webflux.handler;

import org.github.caishijun.webflux.utils.HttpClientUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
public class TimeHandler {

    /**
     * 2、WebFlux的函数式开发模式
     */
    public Mono<ServerResponse> getTime(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Now is " +
                new SimpleDateFormat("HH:mm:ss").format(new Date())
                   + 1/0
        ), String.class);
    }


    /**
     * 3、WebFlux的函数式开发模式-跨应用测试
     */
    public Mono<ServerResponse> getTimeAcrossApplication(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just(
            "Today is " +
                HttpClientUtils.sendGetRequest(HttpClientUtils.getUrl("/time"))
            //       + 1/0
        ), String.class);
    }


    /**
     * 4、WebFlux 服务器推送
     */
    public Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(  // 1
            Flux.interval(Duration.ofSeconds(1)).   // 2
                map(l -> new SimpleDateFormat("HH:mm:ss").format(new Date())),
            String.class);
    }
}


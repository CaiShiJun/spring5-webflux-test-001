package org.github.caishijun.webflux.routes;

import org.github.caishijun.webflux.handler.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 2、WebFlux的函数式开发模式
 */
@Configuration
public class TimeRoutes {
    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/time"), req -> timeHandler.getTime(req))
            .andRoute(GET("/date"), timeHandler::getDate)  // 这种方式相对于上一行更加简洁

            /**
             * 3、WebFlux 服务器推送
             */
            .andRoute(GET("/times"), timeHandler::sendTimePerSec);
    }
}
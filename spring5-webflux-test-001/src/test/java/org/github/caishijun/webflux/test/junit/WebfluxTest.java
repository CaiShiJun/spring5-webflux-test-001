package org.github.caishijun.webflux.test.junit;

import org.github.caishijun.webflux.test.http.HttpClientUtils;
import org.junit.Test;

public class WebfluxTest {
    private static String HOST = "localhost";
    private static int PORT = 8080;

    private static int FOR_TIMES = 1;
    private static int SLEEP_TIME = 0;

    public static String getUrl(String uri) {
        return "http://" + HOST + ":" + PORT + uri;
    }

    /**
     * 1、WebFlux 基于WebMVC注解的方式
     */
    @Test
    public void mvcWebFlux() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            HttpClientUtils.sendGetRequest(getUrl("/mvcWebFlux"));
            Thread.sleep(SLEEP_TIME);
        }
    }

    /**
     * 2、WebFlux的函数式开发模式
     */
    @Test
    public void time() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            HttpClientUtils.sendGetRequest(getUrl("/time"));
            Thread.sleep(SLEEP_TIME);
        }
    }

    /**
     * 2、WebFlux的函数式开发模式
     */
    @Test
    public void date() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            HttpClientUtils.sendGetRequest(getUrl("/date"));
            Thread.sleep(SLEEP_TIME);
        }
    }

    /**
     * 3、WebFlux 服务器推送
     */
    @Test
    public void times() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            HttpClientUtils.sendGetRequest(getUrl("/times"));
            Thread.sleep(SLEEP_TIME);
        }
    }

    @Test
    public void runAll() throws Exception {
        while (true) {
            mvcWebFlux();
            time();
            date();
            times();
        }
    }
}
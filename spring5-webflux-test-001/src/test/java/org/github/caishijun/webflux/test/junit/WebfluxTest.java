package org.github.caishijun.webflux.test.junit;

import org.github.caishijun.webflux.utils.HttpClientUtils;
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
     * 3、WebFlux的函数式开发模式-跨应用测试
     */
    @Test
    public void timeAcrossApplication() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            HttpClientUtils.sendGetRequest(getUrl("/timeAcrossApplication"));
            Thread.sleep(SLEEP_TIME);
        }
    }

    /**
     * 4、WebFlux 服务器推送
     */
    @Test
    public void times() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            HttpClientUtils.sendGetRequest(getUrl("/times"));
            Thread.sleep(SLEEP_TIME);
        }
    }

    /**
     * 5、WebFlux 基于WebMVC注解的方式-跨应用测试
     */
    @Test
    public void mvcWebFluxAcrossApplication() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            HttpClientUtils.sendGetRequest(getUrl("/mvcWebFluxAcrossApplication"));
            Thread.sleep(SLEEP_TIME);
        }
    }

    /**
     * 6、webClient 简单调用
     */
    @Test
    public void webClient() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            HttpClientUtils.sendGetRequest(getUrl("/webClient"));
            Thread.sleep(SLEEP_TIME);
        }
    }

    /**
     * 7、webSocket 简单调用
     */
    @Test
    public void webSocket() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            HttpClientUtils.sendGetRequest(getUrl("/webSocket"));
            Thread.sleep(SLEEP_TIME);
        }
    }

    @Test
    public void runAll() throws Exception {
        while (true) {
            mvcWebFlux();
            time();
            timeAcrossApplication();
            times();
            mvcWebFluxAcrossApplication();
            webClient();
            webSocket();
        }
    }
}
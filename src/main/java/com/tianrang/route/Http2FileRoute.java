package com.tianrang.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class Http2FileRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://stock-price?fixedRate=true&delay=0&period=10000")
                .to("http://hq.sinajs.cn/list=sz000002")
                .process(exchange -> {
                    exchange.toString();
                    String msg = exchange.getMessage().getBody(String.class);
                    System.out.println("msg: " + msg);
                    String a = msg.split("=")[1].substring(1);
                    String[] stockInfo = a.split(",");

                    StringBuilder sb = new StringBuilder();
                    sb.append(stockInfo[0]).append(": ").append(stockInfo[3]);
                    exchange.getMessage().setBody(sb.toString());
                })
                .to("file:///Users/steven/Desktop/b?fileName=stock-price.txt&charset=utf-8");
    }
}
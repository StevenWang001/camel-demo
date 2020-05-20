package com.tianrang.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MoveFileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:///Users/steven/Desktop/a/?delete=true").process(exchange -> {
            Object body = exchange.getIn().getBody();
            System.out.println(body);
        }).to("file:///Users/steven/Desktop/b");
    }
}

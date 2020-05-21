package com.tianrang.components;

import com.tianrang.route.KafkaRoute;
import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyComponents {

    public MyComponents(CamelContext camelContext) throws Exception {
        KafkaRoute kafkaRoute = new KafkaRoute();
//        CamelContext camelContext = (CamelContext)applicationContext.getBean("camelContext");
        camelContext.addRoutes(kafkaRoute);
    }
}

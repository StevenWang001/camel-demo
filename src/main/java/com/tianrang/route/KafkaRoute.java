package com.tianrang.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.springframework.stereotype.Component;

@Component
public class KafkaRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://kafka-producer?fixedRate=true&delay=0&period=10000")
                .setBody(constant("Message from Camel"))          // Message to send
                .setHeader(KafkaConstants.KEY, constant("Camel")) // Key of the message
                .to("kafka:topology-dongqi?brokers=localhost:9092")
                .log("Write message to kafka success");

        from("kafka:topology-dongqi?brokers=localhost:9092")
                .log("Message received from Kafka : ${body}")
                .log("    on the topic ${headers[kafka.TOPIC]}")
                .log("    on the partition ${headers[kafka.PARTITION]}")
                .log("    with the offset ${headers[kafka.OFFSET]}")
                .log("    with the key ${headers[kafka.KEY]}");
    }
}

package com.progressoft.corpay.samples.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaTestController {

    private final KafkaSender kafkaSender;

    @PostMapping("/kafka/{topicName}")
    public void sendToKafka(@PathVariable("topicName") String topicName, @RequestBody String message){
        kafkaSender.sendMessage(topicName, message);
    }
}

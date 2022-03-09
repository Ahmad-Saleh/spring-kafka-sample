package com.progressoft.corpay.samples.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaSender {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topicName, Object message) {
        LOGGER.info("#### -> Producing message -> {}", message);
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                LOGGER.info("Sent message=[{}] " , message);
            }

            @Override
            public void onFailure(Throwable t) {
                LOGGER.warn("Unable to send message=[" + message + "] due to : ", t);
            }
        });

    }
}

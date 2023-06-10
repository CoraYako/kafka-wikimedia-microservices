package com.learningkafka.springboot.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.learningkafka.springboot.constants.KafkaProducerConstants;
import com.learningkafka.springboot.handler.WikimediaChangesHandler;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class WikimediaChangesProducer {

    private final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {
        //to read real time stream data from wikimedia, we use event source
        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, KafkaProducerConstants.TOPIC_NAME);
        EventSource.Builder eventSourceBuilder = new EventSource
                .Builder(eventHandler, URI.create(KafkaProducerConstants.STREAM_DATA_URL));
        EventSource eventSource = eventSourceBuilder.build();

        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }
}

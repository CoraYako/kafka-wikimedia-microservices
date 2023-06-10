package com.learningkafka.springboot.config;

import com.learningkafka.springboot.constants.KafkaProducerConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name(KafkaProducerConstants.TOPIC_NAME)
                .build();
    }
}

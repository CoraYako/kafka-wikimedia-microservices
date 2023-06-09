package com.learningkafka.springboot.service;

import com.learningkafka.springboot.constants.KafkaConsumerConstants;
import com.learningkafka.springboot.entity.WikimediaData;
import com.learningkafka.springboot.repository.WikimediaDataRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private final WikimediaDataRepository wikimediaDataRepository;

    @KafkaListener(topics = KafkaConsumerConstants.TOPIC_NAME, groupId = KafkaConsumerConstants.GROUP_ID)
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Event message received -> %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaDataRepository.save(wikimediaData);
    }
}

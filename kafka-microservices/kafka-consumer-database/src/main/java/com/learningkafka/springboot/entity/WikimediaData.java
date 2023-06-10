package com.learningkafka.springboot.entity;

import com.learningkafka.springboot.constants.KafkaConsumerConstants;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = KafkaConsumerConstants.TOPIC_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = KafkaConsumerConstants.COLUMN_DEFINITION)
    private String wikiEventData;
}

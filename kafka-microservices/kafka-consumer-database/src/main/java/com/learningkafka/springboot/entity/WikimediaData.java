package com.learningkafka.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wikimedia_recent_changes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String wikiEventData;
}

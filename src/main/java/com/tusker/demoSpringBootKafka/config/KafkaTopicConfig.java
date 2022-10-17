package com.tusker.demoSpringBootKafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig{

    @Bean
    public NewTopic messageTopic() {
        return TopicBuilder.name("TuskersTopic").build();
    }

    @Bean
    public NewTopic jsonTopic() {
        return TopicBuilder.name("TuskersJsonTopic").build();
    }
}

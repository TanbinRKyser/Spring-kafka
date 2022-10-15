package com.tusker.demoSpringBootKafka.controller;

import com.tusker.demoSpringBootKafka.kafka.JsonKafkaProducer;
import com.tusker.demoSpringBootKafka.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka/")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    @Autowired
    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish( @RequestBody  User user ){
        jsonKafkaProducer.sendMessage( user );

        return ResponseEntity.ok("Message sent to kafka topic");
    }
}

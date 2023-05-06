package com.ziadDev.app;

import com.ziadDev.app.models.OfferMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class MarketerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarketerApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(KafkaTemplate<String, OfferMessage> kafkaTemplate) {
//        return args -> {
//            kafkaTemplate.send("offers", OfferMessage.builder()
//                            .item("pepsi")
//                            .percentage(25F)
//                            .quantity(2)
//                    .build());
////            kafkaTemplate.send("offers", "offer");
//        };
//    }
}
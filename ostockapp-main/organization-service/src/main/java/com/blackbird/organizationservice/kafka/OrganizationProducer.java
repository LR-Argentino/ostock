package com.blackbird.organizationservice.kafka;

import com.blackbird.organizationservice.model.Organization;
import com.blackbird.organizationservice.model.dto.DTOOrganization;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrganizationProducer {
    private static final Logger logger = LoggerFactory.getLogger(OrganizationProducer.class);
    private NewTopic topic;
    private KafkaTemplate<String, DTOOrganization> kafkaTemplate;

    public OrganizationProducer(NewTopic topic, KafkaTemplate<String, DTOOrganization> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(DTOOrganization organization) {
      logger.debug("Organization event: {} mit ID: {}", organization.getAction(), organization.getOrganizationId());
        Message<DTOOrganization> message = MessageBuilder
                .withPayload(organization)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }
}

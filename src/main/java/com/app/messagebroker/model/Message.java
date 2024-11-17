package com.app.messagebroker.model;

import com.app.messagebroker.enums.MessageBrokerEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "messages")
public class Message {

    @Id
    private String id;
    @Field("content")
    private String content;
    @Field("sender")
    private String sender;
    @Field("broker")
    private MessageBrokerEnum messageBrokerEnum;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageBrokerEnum getMessageBrokerEnum() {
        return messageBrokerEnum;
    }

    public void setMessageBrokerEnum(MessageBrokerEnum messageBrokerEnum) {
        this.messageBrokerEnum = messageBrokerEnum;
    }
}

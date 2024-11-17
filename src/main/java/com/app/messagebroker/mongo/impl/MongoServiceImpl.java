package com.app.messagebroker.mongo.impl;

import com.app.messagebroker.model.Message;
import com.app.messagebroker.mongo.MongoService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class MongoServiceImpl implements MongoService {

    private final MongoTemplate mongoTemplate;

    public MongoServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public void saveMessage(Message message) {
        mongoTemplate.insert(message);
    }
}

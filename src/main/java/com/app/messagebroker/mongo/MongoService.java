package com.app.messagebroker.mongo;

import com.app.messagebroker.model.Message;

public interface MongoService {

    void saveMessage(Message message);
}

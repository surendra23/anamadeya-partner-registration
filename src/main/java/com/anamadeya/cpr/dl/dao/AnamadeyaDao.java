package com.anamadeya.cpr.dl.dao;

import com.anamadeya.cpr.dl.schema.Anamadeya;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.stereotype.Repository;

@Repository
public class AnamadeyaDao {
    MongoClient mongoClient = new MongoClient();
    CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    MongoDatabase database = mongoClient.getDatabase("anamadeya").withCodecRegistry(pojoCodecRegistry);;
    MongoCollection<Document> collection = database.getCollection("partners-data");

    public void register(Anamadeya anamadeya) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String jsonStr = objectMapper.writeValueAsString(anamadeya);
        Document doc = Document.parse(jsonStr);
        collection.insertOne(doc);
    }
}

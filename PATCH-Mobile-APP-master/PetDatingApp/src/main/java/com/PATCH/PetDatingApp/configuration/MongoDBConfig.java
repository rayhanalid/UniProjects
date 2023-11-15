//package com.PATCH.PetDatingApp.configuration;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.gridfs.GridFSBucket;
//import com.mongodb.client.gridfs.GridFSBuckets;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableAutoConfiguration
//public class MongoDBConfig {
//
//    private final String mongoUri = "mongodb+srv://rayhanali:Rambo0101@patch.6wrxyle.mongodb.net/PATCH?retryWrites=true&w=majority";
//
//    @Bean
//    public MongoClient mongoClient() {
//        return MongoClients.create(mongoUri);
//    }
//
//    @Bean
//    public GridFSBucket gridFSBucket(MongoClient mongoClient) {
//        return GridFSBuckets.create(mongoClient.getDatabase("PATCH"));
//    }
//}

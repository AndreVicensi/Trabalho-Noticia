package dao;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;

public class ConexaoMongo {
	private static MongoClient mongoClient;
	private static MongoDatabase database;
	static {
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		mongoClient = new MongoClient("localhost",
				MongoClientOptions.builder()
				.codecRegistry(pojoCodecRegistry).build()); 
		 database = mongoClient.getDatabase("aula1");
		 database = database.withCodecRegistry(pojoCodecRegistry);
	}
	
	public static MongoDatabase db() {
		return database;
	}
}

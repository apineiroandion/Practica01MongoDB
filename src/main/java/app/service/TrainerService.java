package app.service;

import app.model.Trainer;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class TrainerService {
    public static void insertTrainer(Trainer trainer, MongoCollection<Document> collection) {
        Document insert = new Document("name", trainer.getName())
                .append("age", trainer.getAge())
                .append("city", trainer.getCity());
        collection.insertOne(insert);
    }

    public static void deleteTrainer(String name, MongoCollection<Document> collection) {
        Document delete = new Document("name", name);
        collection.deleteOne(delete);
    }
}

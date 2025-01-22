package app.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Trainer {
    private String name;
    private int age;
    private String city;

    public Trainer() {
    }

    public Trainer(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Metodo para convertir a JSON
    public String toJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        } catch (Exception e) {
            System.out.println("Error al convertir a JSON" + e.getMessage());
            return null;
        }
    }

    public static void saveTrainerToMongoDB(String json, MongoClient mongoClient, MongoDatabase database, MongoCollection<Document> collection) {
        try {
            // Deserializar el JSON a un objeto Trainer
            ObjectMapper objectMapper = new ObjectMapper();
            Trainer trainer = objectMapper.readValue(json, Trainer.class);

            collection = database.getCollection("trainers"); // Nombre de la colección

            // Convertir el objeto Trainer a un Document de MongoDB
            Document doc = new Document("name", trainer.getName())
                    .append("age", trainer.getAge())
                    .append("city", trainer.getCity());

            // Insertar el documento en la colección
            collection.insertOne(doc);
            System.out.println("Trainer guardado exitosamente en MongoDB.");

            // Cerrar la conexión
            mongoClient.close();

        } catch (Exception e) {
            System.out.println("Error al guardar el Trainer en MongoDB: " + e.getMessage());
        }
    }

}

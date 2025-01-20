package app.service;

import app.model.Pokemon;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class PokemonService {
    public static void insertPokemon(Pokemon pokemon, MongoCollection<Document> collection) {
        Document insert = new Document("name", pokemon.getName())
                .append("types", pokemon.getTypes())
                .append("level", pokemon.getLevel())
                .append("moves", pokemon.getMoves())
                .append("id_adestrador", pokemon.getId_adestrador());
        collection.insertOne(insert);
    }

    public static void deletePokemon(String name, MongoCollection<Document> collection) {
        Document delete = new Document("name", name);
        collection.deleteOne(delete);
    }
}

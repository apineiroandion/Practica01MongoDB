package app.controller;

import app.model.Pokemon;
import app.model.Trainer;
import app.service.PokemonService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    MongoClient mongoClient; // establece la conexión con la base de datos
    MongoDatabase database;
    MongoCollection<Document> collection;


    public Controller() {
        this.mongoClient = MongoClients.create("mongodb://root:example@172.19.0.2:27017");
        this.database = mongoClient.getDatabase("pokemonej");
        this.collection = database.getCollection("pokemones");
    }

    public void iniciarAp(){
        System.out.println("Creando entrenador...");
        System.out.println("Introduce el nombre del entrenador");
        String name = scanner.nextLine();
        System.out.println("Introduce la edad del entrenador");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduce la ciudad del entrenador");
        String city = scanner.nextLine();

        // Crear entrenador
        Trainer trainer = new Trainer(name, age, city);
        System.out.println("Entrenador creado");
        String json = trainer.toJson();
        System.out.println("Entrenador convertido a JSON");
        trainer.saveTrainerToMongoDB(json, mongoClient, database, collection);
        System.out.println("Entrenador guardado en la base de datos");

//        System.out.println("Meter datos");
//        meterDatos();
//        System.out.println("Datos metidos");
//        System.out.println("1. Meter datos");
//        System.out.println("2. Sacar datos");
//        int opcion = scanner.nextInt();
//        switch (opcion){
//            case 1:
//                meterDatos();
//                break;
//            case 2:
//                sacarDatos();
//                break;
//            default:
//                System.out.println("Opción no válida");
//                break;
//        }

    }

    public void meterDatos(){
        Pokemon pokemon = new Pokemon("Pikachu", new String[]{"Electric"}, 5, new String[]{"Thunderbolt"}, 1);
        PokemonService.insertPokemon(pokemon, collection);

        pokemon = new Pokemon("Charmander", new String[]{"Fire"}, 5, new String[]{"Ember"}, 1);
        PokemonService.insertPokemon(pokemon, collection);
    }

    public void sacarDatos(){
        PokemonService.deletePokemon("Pikachu", collection);
        PokemonService.deletePokemon("Charmander", collection);
    }
}

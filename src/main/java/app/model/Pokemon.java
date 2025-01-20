package app.model;

public class Pokemon {
    private String name;
    private String[] types;
    private int level;
    private String[] moves;
    private int id_adestrador;

    public Pokemon() {
    }

    public Pokemon(String name, String[] types, int level, String[] moves, int id_adestrador) {
        this.name = name;
        this.types = types;
        this.level = level;
        this.moves = moves;
        this.id_adestrador = id_adestrador;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String[] getMoves() {
        return moves;
    }

    public void setMoves(String[] moves) {
        this.moves = moves;
    }

    public int getId_adestrador() {
        return id_adestrador;
    }

    public void setId_adestrador(int id_adestrador) {
        this.id_adestrador = id_adestrador;
    }
}

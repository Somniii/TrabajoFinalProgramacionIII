public class Participante {
    private static int nextId = 10000000;

    private final int id;

    public Participante(){
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

}

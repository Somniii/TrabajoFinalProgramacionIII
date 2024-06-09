public class Participante {
    private final static int idTemp = 10000000;
    private static int id = idTemp;
    private String nombre;

    public Participante(){

    }

    public Participante(String nombre) {
        this.nombre = nombre;
        this.id = id+1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

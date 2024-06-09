public class Administrador {
    private static int nextId = 20000000;
    private final int id;
    private String nombre;
    /*COMENTARIO:Esta clase administrador solo permite un torneo por un administrador , luego se puede cambiar pero solo uno
    Si la compania quiere realizar mas torneo la tenemos que cambiar por un List , pero en el MVP lo dejamos asi
    */
    public Administrador(){
        this.id = 20;
    }
    public Administrador(String nombre){
        this.id = nextId++;
        this.nombre = nombre;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Administrador.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String toString(){
        return "Nombre = "+nombre+"\nId:"+id;
    }
    

}

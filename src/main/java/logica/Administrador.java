/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

public class Administrador extends Persona{
    private static int nextId = 20000000;
    private final int idA;
    /*COMENTARIO:Esta clase administrador solo permite un torneo por un administrador , luego se puede cambiar pero solo uno
    Si la compania quiere realizar mas torneo la tenemos que cambiar por un List , pero en el MVP lo dejamos asi
    */
    public Administrador(){
        this.idA = 20;
    }

    public Administrador(String usuario, String contrasena, String nombre, String email) {
        super(usuario, contrasena, nombre, email);
        this.idA = nextId++;

    }
    
    
    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Administrador.nextId = nextId;
    }

    public int getId() {
        return idA;
    }

    @Override
    public String toString() {
        return "Administrador{" + "idA=" + idA + '}';
    }

}

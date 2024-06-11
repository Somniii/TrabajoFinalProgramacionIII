/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.tournamentproyect;

public class Administrador{
    private static int nextId = 20000000;
    private final int idA;
    private String usuario;
    private String contrasena;
    private String nombre;
    private String email;
    /*COMENTARIO:Esta clase administrador solo permite un torneo por un administrador , luego se puede cambiar pero solo uno
    Si la compania quiere realizar mas torneo la tenemos que cambiar por un List , pero en el MVP lo dejamos asi
    */
    public Administrador(){
        this.idA = 20;
    }

    public Administrador(String usuario, String contrasena, String nombre, String email) {
        this.idA = nextId++;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.email = email;
    }


    
    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Administrador.nextId = nextId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdA() {
        return idA;
    }

    @Override
    public String toString() {
        return "Administrador{" + "idA=" + idA + ", usuario=" + usuario + ", contrasena=" + contrasena + ", nombre=" + nombre + ", email=" + email + '}';
    }



}

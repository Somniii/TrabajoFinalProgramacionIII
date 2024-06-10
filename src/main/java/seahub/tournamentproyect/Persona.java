/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.tournamentproyect;

/**
 *
 * @author tinov
 */
public class Persona {
    private static int nextId = 10000000;
    private final int mainId;
    private String usuario;
    private String contrasena;
    private String nombre;
    private String email;

    public Persona() {
        this.mainId = nextId++;
        this.nombre = nombre;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Persona.nextId = nextId;
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

    
}

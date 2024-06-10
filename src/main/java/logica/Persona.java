/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

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

    //Esto es si se crea una persona vacia
    public Persona() {
        this.mainId = 10;
    }
    public Persona(String nombre){
        this.nombre = nombre;
        this.mainId = nextId++;
    }
    public Persona(String usuario, String contrasena, String nombre, String email) {
        this.mainId = nextId++;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.email = email;
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

    public String toString() {
        return "Persona{" + "mainId=" + mainId + ", usuario=" + usuario + ", contrasena=" + contrasena + ", nombre=" + nombre + ", email=" + email + '}';
    }
    
    

    
}

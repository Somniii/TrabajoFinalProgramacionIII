/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.tournamentproyect;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Participante{
    private static int nextId = 10000000;
    private final int idP;
    private String usuario;
    private String contrasena;
    private String nombre;
    private String email;
    public Participante(){
        //Esta cuando sucede , ver si tiene nombre si no tiene nombre no existe (en torneo) (porque igual tiene id , hay que arreglar)
        this.idP = 10;
    }

    public Participante(String nombre) {
        this.idP = nextId++;
        this.nombre = nombre;
    }
    
    public Participante(String usuario, String contrasena, String nombre, String email) {
        this.idP = nextId++;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.email = email;
    }
    
    
    public int getId() {
        return idP;
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

    public static int getNextId() {
        return nextId;
    }

    public int getIdP() {
        return idP;
    }

    public String toString() {
        return "Participante{" + "idP=" + idP + ", usuario=" + usuario + ", contrasena=" + contrasena + ", nombre=" + nombre + ", email=" + email + '}';
    }

}

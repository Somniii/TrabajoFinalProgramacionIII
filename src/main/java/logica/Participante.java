/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

public class Participante extends Persona{
    private static int nextId = 10000000;
    private final int idP;
    public Participante(){
        //Esta cuando sucede , ver si tiene nombre si no tiene nombre no existe (en torneo) (porque igual tiene id , hay que arreglar)
        this.idP = 10;
    }
    public Participante(String nombre){
        super(nombre);
        this.idP = nextId++;
    }
    public Participante( String usuario, String contrasena, String nombre, String email) {
        super(usuario, contrasena, nombre, email);
        this.idP = nextId++;
    }
    
    public int getId() {
        return idP;
    }

    @Override
    public String toString() {
        return "Participante{" + "idP=" + idP + '}';
    }
    


}

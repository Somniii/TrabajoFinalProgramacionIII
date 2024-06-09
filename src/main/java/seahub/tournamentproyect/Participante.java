/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.tournamentproyect;

public class Participante {
    private static int nextId = 10000000;
    private final int id;
    private String nombre;
    public Participante(){
        //Esta cuando sucede , ver si tiene nombre si no tiene nombre no existe (en torneo) (porque igual tiene id , hay que arreglar)
        this.id = 10;
    }
    public Participante(String nombre){
        this.id = nextId++;
        this.nombre = nombre;
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
    public String toString(){
        return "------------------------------\nId: "+id+"\nNombre: "+nombre;
    }


}

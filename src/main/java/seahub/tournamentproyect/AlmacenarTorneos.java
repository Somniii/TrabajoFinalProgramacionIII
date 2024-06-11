/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.tournamentproyect;

import java.util.ArrayList;
import java.util.List;

public class AlmacenarTorneos {
    private List<Torneo> listaTorneos;

    //CAMBIE ESTA FUNCION
    public AlmacenarTorneos(){
        this.listaTorneos = new ArrayList<>();
    }
    public AlmacenarTorneos(List<Torneo> listaTorneos) {
        this.listaTorneos = listaTorneos;
    }
    //Antes no habia un constructor vacio de almacenarTorneos (Lo comento por si algo falla)
    /*
    Antes era:
        public AlmacenarTorneos(List<Torneo> listaTorneos) {
        this.listaTorneos = new ArrayList<>();
    }
     */

    public List<Torneo> getListaTorneos() {
        return new ArrayList<>(listaTorneos);
    }

    public void setListaTorneos(List<Torneo> listaTorneos) {
        this.listaTorneos = listaTorneos;
    }

    public void anadirTorneo(Torneo t){
        int verificador = 1;
        for(Torneo tAux : listaTorneos){
            if(tAux.getId()==t.getId()){
                verificador = 0;
            }
        }
        if(verificador == 1){
            listaTorneos.add(t);
        }
    }
    //Aca ponemos funciones dependiendo el participante ej
    public void sacarJerarquiaMaxima(Participante p1){
        //Declarar funciones de promedio:
        double sumatoria = 0;
        double promedio;
        int cantidadEncontrado = cantidadVecesParticipo(p1);
        if(cantidadEncontrado == 0){
            System.out.println("No participo en ningun torneo");
        }else{
            int jerarquiaMaxima = 9;
            for(Torneo t : listaTorneos){
                for(Etapa e : t.getListaEtapa()){
                    if(e.getP1().getId()==p1.getId() || e.getP2().getId()==p1.getId()){
                        //Es menor porque cuando mas menor es mas alta la posicion osea , final es mejor que semifinal pero final aca es 0 y semifinal es 1
                        if(jerarquiaMaxima < e.jerarquia){
                            jerarquiaMaxima = e.jerarquia;
                        }
                    }
                }
            }
            System.out.println("JERARQUIA MAXIMA PARTICIPANTE\n"+p1.getNombre()+"\nFUE :"+jerarquiaMaxima);
        }
    }
    public void jerarquiaMaximaPorTorneo(Participante p1){
        //Declarar funciones de promedio:
        double sumatoria = 0;
        double promedio;
        int cantidadEncontrado = cantidadVecesParticipo(p1);
        if(cantidadEncontrado == 0){
            System.out.println("No participo en ningun torneo");
        }else{
            int jerarquiaMaxima;
            for(Torneo t : listaTorneos){
                jerarquiaMaxima = 12;
                for(Etapa e : t.getListaEtapa()){
                    if(e.getP1().getId()==p1.getId() || e.getP2().getId()==p1.getId()){
                        //Es menor porque cuando mas menor es mas alta la posicion osea , final es mejor que semifinal pero final aca es 0 y semifinal es 1
                        if(jerarquiaMaxima < e.jerarquia){
                            jerarquiaMaxima = e.jerarquia;
                        }
                    }
                }
                System.out.println("------------------\nTORNEO:"+t.getNombreTorneo()+"\nPOSICION MAXIMA:"+jerarquiaMaxima);
            }
        }
    }
    public void jerarquiaMaximaPorPromedio(Participante p1){
        //Declarar funciones de promedio:
        double sumatoria = 0;
        double promedio;
        int cantidadEncontrado = cantidadVecesParticipo(p1);
        if(cantidadEncontrado == 0){
            System.out.println("No participo en ningun torneo");
        }else{
            int jerarquiaMaxima;
            for(Torneo t : listaTorneos){
                jerarquiaMaxima = 12;
                for(Etapa e : t.getListaEtapa()){
                    if(e.getP1().getId()==p1.getId() || e.getP2().getId()==p1.getId()){
                        //Es menor porque cuando mas menor es mas alta la posicion osea , final es mejor que semifinal pero final aca es 0 y semifinal es 1
                        if(jerarquiaMaxima < e.jerarquia){
                            jerarquiaMaxima = e.jerarquia;
                        }
                    }
                }
                sumatoria = jerarquiaMaxima + sumatoria;
            }
            promedio = sumatoria/cantidadEncontrado;
            System.out.println("------------------\nPROMEDIO POSICION TORNEO:\n"+promedio);
        }
    }
    public void mostrarGanadoresTorneos(){
        for(Torneo t : listaTorneos){
            t.mostrarGanadorTorneo();
        }
    }
    //Esta funcion te dice la cantidad de veces que una persona participo en torneos , si participo en 2 torneos te salta 2
    public int cantidadVecesParticipo(Participante p1){
        int cantidadEncontrado = 0;
        for(Torneo t : listaTorneos){
            for(Participante p : t.getListaParticipante()){
                if(p1.getId() == p.getId()){
                    cantidadEncontrado++;
                }
            }
        }
        return cantidadEncontrado;
    }

}

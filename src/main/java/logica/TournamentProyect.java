/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package logica;

import java.util.Scanner;
import java.time.LocalDateTime;

public class TournamentProyect {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        fechaActualTest();
        probarTorneo(scan);
    }
    public static void probarTorneo(Scanner scan){
        Torneo torneito = new Torneo("Lol");
        for (int id = 1; id <= 5; id++) {
            Participante participante = new Participante("Juan");
            torneito.ingresarParticipante(participante);
        }
        torneito.mostrarParticipantes();
        torneito.llenarEtapas();
        while(torneito.getPisos()>=0){
            System.out.println("ESTAMOS EN PISO:"+torneito.getPisos());
            torneito.elegirGanador(scan);
        }
        torneito.mostrarGanadorTorneo();
        torneito.eliminarEtapaNegativa();
        torneito.mostrarEtapas();
        torneito.mostrarPorEtapa(scan);
        ArrayParticipantes participantesHistoricos = new ArrayParticipantes();
        participantesHistoricos.anadirParticipantes(torneito.getListaParticipante());
        //participantesHistoricos.mostrarParticipantesHistoricos();
    }
    public static void fechaActualTest(){
        LocalDateTime fechaActual = LocalDateTime.now();

        int añoActual = fechaActual.getYear();
        int mesActual = fechaActual.getMonthValue();
        int diaActual = fechaActual.getDayOfMonth();
        int horaActual = fechaActual.getHour();
        int minutoActual = fechaActual.getMinute();
        LocalDateTime fechaFuturo = fechaActual.plusDays(30); // Suma 30 días a la fecha actual

        System.out.println("Fecha actual: " + fechaActual);
        System.out.println("Año actual: " + añoActual);
        System.out.println("Mes actual: " + mesActual);
        System.out.println("Día actual: " + diaActual);
        System.out.println("Hora actual: "+ horaActual+":"+minutoActual);
    }
}

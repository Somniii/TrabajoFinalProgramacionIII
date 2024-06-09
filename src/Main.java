//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        fechaActualTest();
    }
    public static void probarTorneo(Scanner scan){
        Torneo torneito = new Torneo();
        for (int id = 1; id <= 8; id++) {
            Participante participante = new Participante("Juan");
            torneito.ingresarParticipante(participante);
        }
        torneito.mostrarParticipantes();
        torneito.llenarEtapas();
        /*torneito.mostrarEtapas();
        torneito.mostrarPorEtapa(scan);
        torneito.elegirGanador(scan);
        torneito.pasarGanadorEtapa();
        torneito.mostrarPorEtapa(scan);
        torneito.elegirGanador(scan);
        torneito.mostrarPorEtapa(scan);
        torneito.mostrarGanador();*/
        ArrayParticipantes participantesHistoricos = new ArrayParticipantes();
        participantesHistoricos.anadirParticipantes(torneito.getListaParticipante());
        participantesHistoricos.mostrarParticipantesHistoricos();
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
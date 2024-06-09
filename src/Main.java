//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Torneo torneito = new Torneo();
        for (int id = 1; id <= 12; id++) {
            Participante participante = new Participante("Juan");
            torneito.ingresarParticipante(participante);
        }
        torneito.mostrarParticipantes();
        torneito.llenarEtapas();
        torneito.mostrarEtapas();
        torneito.elegirGanador(scan);
        torneito.mostrarGanador();
    }
}
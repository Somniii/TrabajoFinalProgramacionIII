//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String participante1Nombre = "Juan";
        String participante2Nombre = "María";
        String participante3Nombre = "Pedro";
        String participante4Nombre = "Ana";
        String participante5Nombre = "Carlos";
        String participante6Nombre = "Sofía";
        String participante7Nombre = "Diego";
        String participante8Nombre = "Laura";
        String participante9Nombre = "Alejandro";
        String participante10Nombre = "Sandra";
        String participante11Nombre = "Marco";
        String participante12Nombre = "Natalia";
        String participante13Nombre = "Daniel";

        Participante participante1 = new Participante(participante1Nombre);
        Participante participante2 = new Participante(participante2Nombre);
        Participante participante3 = new Participante(participante3Nombre);
        Participante participante4 = new Participante(participante4Nombre);
        Participante participante5 = new Participante(participante5Nombre);
        Participante participante6 = new Participante(participante6Nombre);
        Participante participante7 = new Participante(participante7Nombre);
        Participante participante8 = new Participante(participante8Nombre);
        Participante participante9 = new Participante(participante9Nombre);
        Participante participante10 = new Participante(participante10Nombre);
        Participante participante11 = new Participante(participante11Nombre);
        Participante participante12 = new Participante(participante12Nombre);
        Participante participante13 = new Participante(participante13Nombre);

        Torneo torneito = new Torneo();
        torneito.ingresarParticipante(participante1);
        torneito.ingresarParticipante(participante2);
        torneito.ingresarParticipante(participante3);
        torneito.ingresarParticipante(participante4);
        torneito.ingresarParticipante(participante5);
        torneito.ingresarParticipante(participante6);
        torneito.ingresarParticipante(participante7);
        torneito.ingresarParticipante(participante8);
        torneito.ingresarParticipante(participante9);
        torneito.ingresarParticipante(participante10);
        torneito.ingresarParticipante(participante11);
        torneito.ingresarParticipante(participante12);
        torneito.ingresarParticipante(participante13);
        torneito.mostrarParticipantes();
        torneito.llenarEtapas();
        torneito.mostrarEtapas();
        torneito.elegirGanador(scan);

    }
}
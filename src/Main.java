//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Torneo torneito = new Torneo();
        for (int id = 1; id <= 8; id++) {
            Participante participante = new Participante();
            torneito.ingresarParticipante(participante);
        }
        torneito.mostrarParticipantes();
        torneito.llenarEtapas();
        torneito.mostrarEtapas();

    }
}
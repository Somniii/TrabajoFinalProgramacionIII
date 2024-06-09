import java.util.ArrayList;
import java.util.List;

public class ArrayParticipantes {
    private List<Participante> listaParticipante;
    public ArrayParticipantes(){
        this.listaParticipante = new ArrayList<>();
    }

    public List<Participante> getListaParticipante() {
        return new ArrayList<>(listaParticipante); // Regresa una copia de la lista
    }

    public void setListaParticipante(List<Participante> listaParticipante) {
        this.listaParticipante = listaParticipante;
    }

    public void anadirParticipante(Participante pAux){
        //Si tiene un participante con igual id no lo anade
        int verificador = 1;
        for(Participante pLista : listaParticipante ){
            if(pLista.getId()==pAux.getId()){
                verificador = 0;
            }
        }
        if(verificador == 1){
            listaParticipante.add(pAux);
        }
    }
    public void anadirParticipantes(List <Participante> listaParticipanteAnadir){
        //Si tiene un participante con igual id no lo anade
        if(listaParticipanteAnadir == null){
            System.out.println("Vacoa");
        }
        int verificador = 1;
        for(Participante pListaAnadir : listaParticipanteAnadir){
                for(Participante pListaClase : listaParticipante ){
                if(pListaClase.getId()==pListaAnadir.getId()){
                    verificador = 0;
                }
            }
            if(verificador == 1){
                listaParticipante.add(pListaAnadir);
            }
        }
    }
    public void mostrarParticipantesHistoricos(){
        if(listaParticipante == null){
            System.out.println("ES NULL");
        }
        else {
            for (Participante pAux : listaParticipante) {
                System.out.println(pAux.toString());
            }
        }
    }
}

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
    //public void sacar promedioPosicion(Participante p1){}

}

import java.util.List;
import java.util.ArrayList;

public class ArrayAdministradores {
    private List<Administrador> listaAdministradores;

    public ArrayAdministradores(){
        listaAdministradores = new ArrayList<>();
    }
    public ArrayAdministradores(List <Administrador> listaAdministradores){
        this.listaAdministradores = listaAdministradores;
    }

    public List<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(List<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public void anadirAdministradores(Administrador adm){
        int verificador = 1;
        for(Administrador lAux : listaAdministradores){
            if(adm.getId() == lAux.getId()){
                verificador = 0;
            }
        }
        if(verificador == 1){
            listaAdministradores.add(adm);
        }
    }
    public void mostrarAdministradores(){
        for(Administrador lAux : listaAdministradores){
            System.out.println(lAux.toString());
        }
    }
}

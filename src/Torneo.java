import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Torneo {
    private List<Participante> listaParticipante;
    private List<Etapa> listaEtapa;

    public Torneo() {
        this.listaParticipante = new ArrayList<>();
        this.listaEtapa = new ArrayList<>();
    }


    public List<Participante> getListaParticipante() {
        return new ArrayList<>(listaParticipante); // Regresa una copia de la lista
    }

    public void setListaParticipante(List<Participante> listaParticipante) {
        this.listaParticipante = listaParticipante;
    }

    public List<Etapa> getListaEtapa() {
        return new ArrayList<>(listaEtapa); // Regresa una copia de la lista
    }

    public void setListaEtapa(List<Etapa> listaEtapa) {
        this.listaEtapa = listaEtapa;
    }
    //Aniade un participante al torneo
    public void ingresarParticipante(Participante p1){
        listaParticipante.add(p1);
    }
    //Aniade todos los participantes a las etapas del torneo
    //Funciona en el 90% de los casos , no funciona ej si ponemos 3 personas
    public void llenarEtapas(){
        double cantidadEtapas = listaParticipante.size()/2;
        int contador = 0;
        //Esto sirve para buscar la cantidad de etapas que debe tener al cuadrado ,
        //Si tiene 3 participantes entonces necesita 2 etapas
        //Si se pueden llenar 6 etapas entonces necesita 8 y asi
        while(cantidadEtapas > Math.pow(2,contador)){
            contador++;
        }
        double cantidadEtapasCuadradas = Math.pow(2,contador);
        System.out.println("Etapas a realizar:"+Math.pow(2,contador));
        //Tengo que colocar los usuarios en las etapas , por cada etapa van dos usuarios
        //3 Soluciones a hacer:
        //1.Ver como ingreso cada dos usuarios
        //2.Si los dos usuarios que coloco me provocan que a futuro haya una etapa vacia , lo tengo que empezar a llenar de a un usuario
        //3.Llenar de a un usuario

        //Primero recorro las etapas y pongo 2 usuarios por cada una
        int i = 0;
        while(i<cantidadEtapasCuadradas){
            Participante aux1 = listaParticipante.get(i);
            Participante aux2 = new Participante();
            listaEtapa.add(new Etapa(aux1 ,aux2 , contador));
            System.out.println("Coloca el id:"+aux1.getId());
            i++;
        }
        int j=i;
        for(Etapa eAux : listaEtapa){
            System.out.println("j"+j+"i"+i);


            System.out.println("Pasa");
            Participante pAux = listaParticipante.get(j);
            System.out.println("Coloca el id:"+pAux.getId());
            eAux.setP2(listaParticipante.get(j));

            j++;
            if(j>listaParticipante.size()-1){
                break;
            }
        }
    }

    public void mostrarParticipantes(){
        if(listaParticipante!=null){
            for(Participante pAux : listaParticipante){
                System.out.println(pAux.getId());
            }
        }
    }
    public void mostrarEtapas(){
        if(listaEtapa!=null){
            System.out.println("Cantidad etapas :"+listaEtapa.size());
            for(Etapa eAux : listaEtapa){
                Participante p1Aux = eAux.getP1();
                Participante p2Aux = eAux.getP2();
                System.out.println("Id:"+p1Aux.getId()+"|Id:"+p2Aux.getId()+"|Jerarquia:"+eAux.getJerarquia());
            }
        }
    }
    //Anda
    public void elegirGanador( Scanner scan){
        System.out.println("Entra a el void elegirGanador");
        for(Etapa aux :listaEtapa){
            System.out.println("Entra al for de elegirGanador");
            if(aux.getP2()!=null){
                Participante p1 = aux.getP1();
                Participante p2 = aux.getP2();
                System.out.println("Elija ganador:\n1."+p1.getNombre()+"/VS/2."+p2.getNombre());
                System.out.println("Elije 1 o 2");
                int opcion = scan.nextInt();
                if(opcion == 1){
                    aux.setGanador(aux.getP1());
                }else if(opcion == 2){
                    aux.setGanador(aux.getP2());
                }else{
                    System.out.println("Ingreso una opcion invalida");
                }
            }else{
                aux.setGanador(aux.getP1());
            }


        }
    }
    //Anda
    public void mostrarGanador(){
        for(Etapa eAux : listaEtapa){
            Participante pAux = eAux.getGanador();
            System.out.println("El ganador fue: "+ pAux.getNombre());
        }
    }
}

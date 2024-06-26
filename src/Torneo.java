import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Torneo {
    private List<Participante> listaParticipante;
    private List<Etapa> listaEtapa;
    private static int totalPisos;
    private int pisos;
    private static int nextId = 30000000;
    private final int id;
    private String nombreTorneo;
    private Administrador adm;
    private Participante ganadorTorneo;

    public Torneo() {
        this.id = 30;
    }
    public Torneo(String nombreTorneo) {
        this.listaParticipante = new ArrayList<>();
        this.listaEtapa = new ArrayList<>();
        this.id = nextId++;
        this.nombreTorneo = nombreTorneo;
        this.adm = new Administrador();
    }
    public Torneo(String nombreTorneo , Administrador adm){
        this.listaParticipante = new ArrayList<>();
        this.listaEtapa = new ArrayList<>();
        this.id = nextId++;
        this.nombreTorneo = nombreTorneo;
        this.adm = adm;
    }

    public Participante getGanadorTorneo() {
        return ganadorTorneo;
    }

    public void setGanadorTorneo(Participante ganadorTorneo) {
        this.ganadorTorneo = ganadorTorneo;
    }

    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Torneo.nextId = nextId;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public int getTotalPisos() {
        return totalPisos;
    }

    public void setTotalPisos(int totalPisos) {
        this.totalPisos = totalPisos;
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
        //System.out.println("Etapas a realizar:"+Math.pow(2,contador));
        setTotalPisos(contador);
        setPisos(contador);
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
            LocalDateTime fechaActual = LocalDateTime.now();
            listaEtapa.add(new Etapa(aux1 ,aux2 , contador, fechaActual));
            //System.out.println("Coloca el id:"+aux1.getId());
            i++;
        }
        int j=i;
        for(Etapa eAux : listaEtapa){
            System.out.println("j"+j+"i"+i);


            //System.out.println("Pasa");
            Participante pAux = listaParticipante.get(j);
            //System.out.println("Coloca el id:"+pAux.getId());
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
                System.out.println("Id PARTICIPANTE 1:"+p1Aux.getId()+"|Id PARTICIPANTE 2:"+p2Aux.getId()+"|Jerarquia:"+eAux.getJerarquia());
            }
        }
    }
    //Anda
    public void verificarSiTerminoTorneo(){
        if(pisos == 0){
            System.out.println("No se pueden ver ganadores porque ya termino el torneo");
        }
    }
    public void elegirGanador( Scanner scan){
        //System.out.println("Entra a el void elegirGanador");
        //Si funciona loq ue estoy intentando tengoq ue cambiar el if de pisos , direcamtente quitar el if de la linea de abajo
        if(pisos != 99){
            for(Etapa aux :listaEtapa){
                //PONGO FECHA ACTUAL ACA POR SI ELIGE DE A UNO AL GANADO SOLO COPIA Y PEGA , SE QUE CONSUME MAS RECURSOS
                LocalDateTime fechaActual = LocalDateTime.now();
                System.out.println("ESTAMOS EN PISO: " +pisos);
                mostrarEtapasPorCargaDePiso(pisos);
                if(aux.jerarquia==pisos){
                    //System.out.println("Entra al for de elegirGanador");
                    Participante p2Aux = aux.getP2();
                    if(p2Aux.getNombre()!=null){
                        System.out.println("En jerarquia "+aux.getJerarquia());
                        Participante p1 = aux.getP1();
                        Participante p2 = aux.getP2();
                        System.out.println("Elija ganador:\n1."+p1.getId()+"/VS/2."+p2.getId());
                        System.out.println("Elije 1 o 2");
                        int opcion = scan.nextInt();

                        if(pisos == 0){
                            if(opcion == 1){
                                setGanadorTorneo(aux.getP1());
                            }
                            else if(opcion == 2){
                                setGanadorTorneo(aux.getP2());
                            }
                            break;
                        }else{
                            if(opcion == 1){
                                aux.setGanador(aux.getP1());
                            }else if(opcion == 2){
                                aux.setGanador(aux.getP2());
                        }

                        }/*else{
                            System.out.println("Ingreso una opcion invalida");
                        }
                        */
                        aux.setFechaGanador(fechaActual);
                    }else{

                        aux.setFechaGanador(fechaActual);
                        aux.setGanador(aux.getP1());
                    }
                }else{

                }
            }

            pasarGanadorEtapa();

        }
        else{
            System.out.println("YA EXISTE GANADOR DE TORNEO :ES:");
            mostrarGanadorTorneo();
        }

    }

    public void pasarGanadorEtapa(){
        double tEtapaBaja = Math.pow(2,pisos);
        if(pisos == 0){
            System.out.println("Va a cargar y crear la etapa -1");
        }
        setPisos(getPisos()-1);
        LocalDateTime fechaActual = LocalDateTime.now();
        /*Carga los ganadores de la etapa anterior a la siguiente*/
        for(int i = 0 ; i < tEtapaBaja ; i= i+2){
                Etapa e1Aux = listaEtapa.get(i);
                Etapa e2Aux = listaEtapa.get(i+1);
                listaEtapa.add(new Etapa(e1Aux.getGanador(),e2Aux.getGanador(), getPisos(),fechaActual));
        }
    }
    public void mostrarGanadorEtapas(){
        for(Etapa eAux : listaEtapa){
            Participante pAux = eAux.getGanador();
            System.out.println("ETAPA "+eAux.jerarquia+"|"+pAux.toString());
        }
    }
    public void mostrarPorEtapa(Scanner scan){
        System.out.println("Ingrese la etapa a buscar");
        int buscar = scan.nextInt();
        for(Etapa eAux : listaEtapa){
            if(eAux.getJerarquia()== buscar){
                if(eAux.getP1() ==null || eAux.getP2()==null){
                    break;
                }
                System.out.println(eAux.getP1().toString());
                System.out.println(eAux.getP2().toString());
                System.out.println("Jerarquia:"+eAux.jerarquia);
            }

        }
    }
    public void mostrarGanadorTorneo(){
        System.out.println("GANADOR DEL TORNEO: "+ganadorTorneo.toString());
    }
    public void mostrarEtapasPorCargaDePiso(int buscar){
        for(Etapa eAux : listaEtapa){
            if(eAux.getJerarquia()== buscar){
                if(eAux.getP1() ==null || eAux.getP2()==null){
                    break;
                }
                System.out.println(eAux.getP1().toString());
                System.out.println(eAux.getP2().toString());
                System.out.println("Jerarquia:"+eAux.jerarquia);
            }

        }
    }
    public void eliminarEtapaNegativa() {
        // Iterate in reverse order to avoid ConcurrentModificationException
        for (int i = listaEtapa.size() - 1; i >= 0; i--) {
            Etapa eAux = listaEtapa.get(i);
            if (eAux.jerarquia == -1) {
                listaEtapa.remove(i); // Remove the element at the current index
            }
        }
    }


}

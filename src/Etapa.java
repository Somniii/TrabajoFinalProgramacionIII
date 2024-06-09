public class Etapa {
    private Participante p1,p2, ganador;
    int jerarquia;

    public Etapa() {
    }

    public Etapa(Participante p1, Participante p2,  int jerarquia) {
        this.p1 = p1;
        this.p2 = p2;
        this.ganador = ganador;
        this.jerarquia = jerarquia;
    }


    public Participante getP1() {
        return p1;
    }

    public void setP1(Participante p1) {
        this.p1 = p1;
    }

    public Participante getP2() {
        return p2;
    }

    public void setP2(Participante p2) {
        this.p2 = p2;
    }

    public Participante getGanador() {
        return ganador;
    }

    public void setGanador(Participante ganador) {
        this.ganador = ganador;
    }

    public int getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(int jerarquia) {
        this.jerarquia = jerarquia;
    }
}

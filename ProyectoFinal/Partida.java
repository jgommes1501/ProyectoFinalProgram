package ProyectoFinal;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Partida {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Jugador jugador;

    private Date fecha;
    private int puntuacionFinal;

    public Partida() {}

    public Partida(Date fecha, int puntuacionFinal) {
        this.fecha = fecha;
        this.puntuacionFinal = puntuacionFinal;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "fecha=" + fecha +
                ", puntuacionFinal=" + puntuacionFinal +
                '}';
    }
}

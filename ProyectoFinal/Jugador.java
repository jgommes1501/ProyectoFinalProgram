package ProyectoFinal;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autogenerado
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    private int vidas = 3;
    private int puntos = 0;

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Partida> partidas = new ArrayList<>();

    // Constructor por defecto (obligatorio para JPA)
    public Jugador() {}

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void agregarPartida(Partida partida) {
        partidas.add(partida);
        partida.setJugador(this);
    }

    // Lógica del juego
    public void perderVida() {
        if (vidas > 0) vidas--;
    }

    public void ganarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public boolean haGanado() {
        return puntos >= 100;
    }

    public boolean haPerdido() {
        return vidas <= 0;
    }

    @Override
    public String toString() {
        return "Jugador: " + nombre + " | Vidas: " + vidas + " | Puntos: " + puntos;
    }
}

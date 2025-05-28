
package Tema8;

import java.util.HashMap;
import java.util.Map;

public class BDManager {
    private Map<String, JugadorData> jugadores;
    private int nextId;

    public BDManager() {
        jugadores = new HashMap<>();
        nextId = 1;
    }

    public void close() {
        // No necesita implementación
    }

    public int buscarJugador(String nombre) {
        return jugadores.containsKey(nombre) ? jugadores.get(nombre).id : -1;
    }

    public int crearJugador(String nombre) {
        int id = nextId++;
        jugadores.put(nombre, new JugadorData(id));
        return id;
    }

    public void actualizarJugador(int id, int puntos, int vidas, String estado) {
        for (JugadorData jugador : jugadores.values()) {
            if (jugador.id == id) {
                jugador.puntos = puntos;
                jugador.vidas = vidas;
                jugador.estado = estado;
                break;
            }
        }
    }

    public void guardarPartida(int jugadorId, int puntosFinales, String resultado) {
        for (JugadorData jugador : jugadores.values()) {
            if (jugador.id == jugadorId) {
                jugador.puntos = puntosFinales;
                jugador.estado = resultado;
                break;
            }
        }
    }

    private static class JugadorData {
        int id;
        int puntos;
        int vidas;
        String estado;

        JugadorData(int id) {
            this.id = id;
            this.puntos = 0;
            this.vidas = 3;
            this.estado = "jugando";
        }
    }
}
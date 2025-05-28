package Tema8;


import java.util.HashMap;

public class BaseDeDatos {
    private static HashMap<String, Jugador> jugadores = new HashMap<>();

    public static void guardarEstadisticas(Jugador jugador) {
        jugadores.put(jugador.getNombre(), jugador);
    }

    public static Jugador obtenerEstadisticas(String nombre) {
        return jugadores.get(nombre);
    }

    public static void mostrarEstadisticas() {
        for (Jugador j : jugadores.values()) {
            System.out.println(j);
        }
    }
}
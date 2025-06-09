package ProyectoFinal;

public class Fran {
    public static void main(String[] args) {
        BDObjectDBManager bd = new BDObjectDBManager();

        // Crear un jugador
        Jugador jugador = new Jugador("Ana");

        // Guardar jugador en la BD orientada a objetos
        bd.guardarJugador(jugador);

        // Buscar jugador
        Jugador buscado = bd.buscarJugadorPorNombre("Ana");
        System.out.println("Jugador encontrado: " + buscado);

        // Actualizar jugador
        buscado.ganarPuntos(500);
        bd.actualizarJugador(buscado);

        // Confirmar actualización
        Jugador actualizado = bd.buscarJugadorPorNombre("Ana");
        System.out.println("Jugador actualizado: " + actualizado);

        bd.close();
    }
}

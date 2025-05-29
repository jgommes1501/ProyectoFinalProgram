package Tema8;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class juego {
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        BDManager bd = null;
        try {
            System.out.println("¡Bienvenido al Space Invaders!");
            System.out.print("Introduce tu nombre: ");
            String nombre = sc.nextLine();

            bd = new BDManager();

            int jugadorId = bd.buscarJugador(nombre);
            if (jugadorId == -1) {
                jugadorId = bd.crearJugador(nombre);
                System.out.println("Nuevo jugador creado.");
            } else {
                System.out.println("Jugador encontrado.");
            }

            Jugador jugador = new Jugador(nombre);
            Nave nave = new Nave();
            ArrayList<Meteoro> meteoros = new ArrayList<>();

            while (!jugador.haGanado() && !jugador.haPerdido()) {
                if (rand.nextInt(10) < 3) {
                    meteoros.add(new Meteoro(rand.nextInt(10), 0));
                }

                Iterator<Meteoro> it = meteoros.iterator();
                while (it.hasNext()) {
                    Meteoro meteoro = it.next();
                    meteoro.mover();
                    if (meteoro.getX() == nave.getX() && meteoro.getY() == nave.getY()) {
                        jugador.perderVida();
                        it.remove();
                        System.out.println("¡Impacto! Has perdido una vida.");
                    }
                }

                System.out.println(jugador);
                System.out.println(nave);

                System.out.println("Elige una opción:");
                System.out.println("1. Mover izquierda");
                System.out.println("2. Mover derecha");
                System.out.println("3. Mover arriba");
                System.out.println("4. Mover abajo");
                System.out.println("5. Disparar");

                int opcion = Integer.parseInt(sc.nextLine());
                try {
                    switch (opcion) {
                        case 1: nave.moverIzquierda(); break;
                        case 2: nave.moverDerecha(); break;
                        case 3: nave.moverArriba(); break;
                        case 4: nave.moverAbajo(); break;
                        case 5:
                            if (rand.nextInt(100) < 30) {
                                jugador.ganarPuntos(100);
                                System.out.printf("¡Disparo acertado! +%d puntos.%n", 100);
                            } else {
                                System.out.println("¡Disparo fallido!");
                            }
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                } catch (NaveException e) {
                    System.out.printf("Error: %s%n", e.getMessage());
                }

                bd.actualizarJugador(
                    jugadorId,
                    jugador.getPuntos(),
                    jugador.getVidas(),
                    jugador.haGanado() ? "ganado" : jugador.haPerdido() ? "perdido" : "jugando"
                );
            }

            if (jugador.haGanado()) {
                System.out.printf("¡Felicidades, %s! Has ganado.%n", jugador.getNombre());
                bd.guardarPartida(jugadorId, jugador.getPuntos(), "ganado");
            } else {
                System.out.printf("¡Lo siento, %s! Has perdido.%n", jugador.getNombre());
                bd.guardarPartida(jugadorId, jugador.getPuntos(), "perdido");
            }

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, introduce un número.");
        } catch (ConcurrentModificationException e) {
            System.out.println("Error al modificar la lista de meteoros.");
        } catch (Exception e) {
            System.out.printf("Ha ocurrido un error inesperado: %s%n", e.getMessage());
            e.printStackTrace();
        } finally {
            if (bd != null) {
                bd.close();
            }
            sc.close();
        }
    }
}

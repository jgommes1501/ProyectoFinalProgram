package ProyectoFinal;

import java.util.Random;

public class Meteoro {
    private int x;  // Coordenada X del meteoro
    private int y;  // Coordenada Y del meteoro

    // Constructor que inicializa la posición del meteoro
    public Meteoro(int ancho, int alto) {
        Random random = new Random();
        if (ancho <= 0 || alto <= 0) {
            throw new IllegalArgumentException("Las dimensiones deben ser positivas");
        }
        x = random.nextInt(ancho);
        y = 0;
        int velocidad = 1 + random.nextInt(3); // 1, 2 o 3
    }


    // Obtener la posición X del meteoro
    public int getX() {
        return x;
    }

    // Obtener la posición Y del meteoro
    public int getY() {
        return y;
    }

    // Método para mover el meteoro (por ejemplo, que se mueva hacia abajo)
    public void mover() {
        y += 10;  // El meteoro baja 10 unidades en cada actualización
    }

    // Método para mostrar la posición del meteoro
    public void mostrarPosicion() {
        System.out.println("Posición del meteoro: X = " + x + ", Y = " + y);
    }

    // Método principal para probar el meteoro
    public static void main(String[] args) {
        // Crear un meteoro en una pantalla de 800x600 (por ejemplo)
        Meteoro meteoro = new Meteoro(800, 600);

        // Mostrar la posición inicial
        meteoro.mostrarPosicion();

        // Mover el meteoro
        meteoro.mover();

        // Mostrar la nueva posición
        meteoro.mostrarPosicion();
    }
}

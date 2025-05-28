package Tema8;

import java.util.Scanner;

public class EjemploScanner {
    public static void main(String[] args) {
        // Crear el objeto Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, introduce tu nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Hola, " + nombre + "!");

        // Cerrar el Scanner
        scanner.close();
    }
}
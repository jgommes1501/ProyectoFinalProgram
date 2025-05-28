package ProyectoFinal;

public class jugador {
    private String nombre;
    private int vidas;
    private int puntuacion;

    public jugador(String nombre) {
        this.nombre = nombre;
        this.vidas = 3;
        this.puntuacion = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void perderVida() {
        if (vidas > 0) vidas--;
    }

    public void ganarPuntos(int puntos) {
        puntuacion += puntos;
    }

    public boolean haGanado() {
        return puntuacion >= 10000;
    }

    public boolean haPerdido() {
        return vidas <= 0;
    }
}

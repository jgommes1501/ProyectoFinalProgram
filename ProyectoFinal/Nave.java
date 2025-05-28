package ProyectoFinal;

public class Nave {
    private int x;
    private int y;

    public Nave() {
        x = 0;
        y = 0;
    }

    public void moverIzquierda() {
        x--;
    }

    public void moverDerecha() {
        x++;
    }

    public void moverArriba() {
        y--;
    }

    public void moverAbajo() {
        y++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Nave en (" + x + ", " + y + ")";
    }
}

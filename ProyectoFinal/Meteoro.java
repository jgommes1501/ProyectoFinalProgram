package ProyectoFinal;


public class Meteoro {
    private int x;
    private int y;

    public Meteoro(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void mover() {
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
        return "Meteoro en (" + x + ", " + y + ")";
    }
}

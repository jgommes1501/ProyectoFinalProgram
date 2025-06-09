package ProyectoFinal;


import javax.persistence.*;
import java.util.List;

public class BaseDeDatos {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("juego.odb");

    public static void guardarJugador(Jugador jugador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(jugador); // Guarda o actualiza
        em.getTransaction().commit();
        em.close();
    }

    public static Jugador obtenerJugador(String nombre) {
        EntityManager em = emf.createEntityManager();
        Jugador jugador = em.find(Jugador.class, nombre);
        em.close();
        return jugador;
    }

    public static void mostrarTodosLosJugadores() {
        EntityManager em = emf.createEntityManager();
        List<Jugador> jugadores = em.createQuery("SELECT j FROM Jugador j", Jugador.class).getResultList();
        for (Jugador j : jugadores) {
            System.out.println(j);
        }
        em.close();
    }

    public static void cerrar() {
        emf.close();
    }
}

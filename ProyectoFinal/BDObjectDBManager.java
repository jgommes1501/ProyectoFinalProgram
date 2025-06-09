package ProyectoFinal;

import javax.persistence.*;
import java.util.List;

public class BDObjectDBManager {
    private EntityManagerFactory emf;
    private EntityManager em;

    public BDObjectDBManager() {
        emf = new com.objectdb.jpa.Provider().createEntityManagerFactory("objectdb:$objectdb/db/evento.odb", null);
        em = emf.createEntityManager();
        System.out.println("Conexión a base de datos orientada a objetos establecida.");
    }

    public void close() {
        if (em != null) em.close();
        if (emf != null) emf.close();
        System.out.println("Conexión cerrada.");
    }

    public void guardarJugador(Jugador jugador) {
        em.getTransaction().begin();
        em.persist(jugador);
        em.getTransaction().commit();
    }

    public Jugador buscarJugadorPorNombre(String nombre) {
        TypedQuery<Jugador> query = em.createQuery(
            "SELECT j FROM Jugador j WHERE j.nombre = :nombre", Jugador.class);
        query.setParameter("nombre", nombre);
        List<Jugador> resultados = query.getResultList();
        return resultados.isEmpty() ? null : resultados.get(0);
    }

    public void actualizarJugador(Jugador jugador) {
        em.getTransaction().begin();
        em.merge(jugador);
        em.getTransaction().commit();
    }

    public void guardarPartida(Partida partida) {
        em.getTransaction().begin();
        em.persist(partida);
        em.getTransaction().commit();
    }
}

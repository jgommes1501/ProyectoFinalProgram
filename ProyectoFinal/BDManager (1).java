package ProyectoFinal;

import java.sql.*;

public class BDManager {
    private Connection conexion;

    public BDManager() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://localhost:3306/Juegos";
        String usuario = "root";
        String contraseña = "";
        conexion = DriverManager.getConnection(url, usuario, contraseña);
        System.out.println("Conexión a la base de datos establecida.");
    }

    public void close() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int buscarJugador(String nombre) throws SQLException {
        String sql = "SELECT id FROM jugadores WHERE nombre = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }

    public int crearJugador(String nombre) throws SQLException {
        String sql = "INSERT INTO jugadores (nombre, puntos, vidas, estado) VALUES (?, 0, 3, 'jugando')";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nombre);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }

    public void actualizarJugador(int id, int puntos, int vidas, String estado) throws SQLException {
        String sql = "UPDATE jugadores SET puntos = ?, vidas = ?, estado = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, puntos);
            stmt.setInt(2, vidas);
            stmt.setString(3, estado);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void guardarPartida(int jugadorId, int puntosFinales, String resultado) throws SQLException {
        String sql = "INSERT INTO partidas (jugador_id, puntos_final, resultado) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, jugadorId);
            stmt.setInt(2, puntosFinales);
            stmt.setString(3, resultado);
            stmt.executeUpdate();
        }
    }
}
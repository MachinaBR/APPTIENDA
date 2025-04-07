import java.sql.Connection;
import java.sql.PreparedStatement;

public class Actualizarproducto {
    
    public static void actualizarProducto(int id, String nombre, int cantidad, double precio) {
        try (Connection conn = ConexionDB.conectar()) {
            String sql = "UPDATE productos SET nombre = ?, cantidad = ?, precio = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setInt(2, cantidad);
            stmt.setDouble(3, precio);
            stmt.setInt(4, id);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("\u2705 Producto actualizado correctamente.");
            } else {
                System.out.println("\u26A0\uFE0F No se encontr\u00f3 el producto para actualizar.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
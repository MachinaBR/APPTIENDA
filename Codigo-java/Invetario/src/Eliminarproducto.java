import java.sql.Connection;
import java.sql.PreparedStatement;

public class Eliminarproducto {
    
    public static void eliminarProducto(int id) {
        try (Connection conn = ConexionDB.conectar()) {
            String sql = "DELETE FROM productos WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("\u2705 Producto eliminado correctamente.");
            } else {
                System.out.println("\u26A0\uFE0F No se encontr\u00f3 el producto para eliminar.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
}

}

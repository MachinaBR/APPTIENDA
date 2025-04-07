import java.sql.Connection;
import java.sql.PreparedStatement;

public class InvetarioDB {

    
    public static void insertarProducto(Invetario producto){
          try (Connection conn = ConexionDB.conectar()) {
            String sql = "INSERT INTO productos (nombre, categoria, precio, cantidad) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getCategoria());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getCantidad());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("\u2705 Producto insertado correctamente.");
            } else {
                System.out.println("\u26A0\uFE0F No se insert\u00f3 el producto.");
            }
        } catch (Exception e) {
            e.printStackTrace();


    }
    }

    public static void actualizarProducto(int idActualizar, String nuevoNombre, int nuevaCantidad, double nuevoPrecio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarProducto'");
    }

	public static void eliminarProducto(int idEliminar) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'eliminarProducto'");
	}
}
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Mostrarproductos {

    public static void MostrarProductos() {
        try (Connection conn = ConexionDB.conectar()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");

            ArrayList<Invetario> listaProductos = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int cantidad = 0; // no se usa
                double precio = rs.getDouble("precio");
                String proveedor = "N/A";
                String categoria = rs.getString("categoria");

                Invetario producto = new Invetario(id, nombre, cantidad, precio, proveedor, categoria);
                listaProductos.add(producto);
            }

            for (Invetario p : listaProductos) {
                System.out.println(p.getId() + " - " + p.getNombre() +
                        " (" + p.getCategoria() + ")  | Precio: $" + p.getPrecio());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}
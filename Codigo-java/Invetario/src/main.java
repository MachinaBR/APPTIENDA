import java.sql.Connection;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Connection conn = ConexionDB.conectar();
        if (conn != null) {
            System.out.println("conexion exitosa");

            System.out.println("--- Ingreso de nuevo producto ---");

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Categoria: ");
            String categoria = sc.nextLine();

            System.out.print("Precio: ");
            double precio = sc.nextDouble();

            System.out.print("cantidad: ");
            double cantidad = sc.nextDouble();

            Invetario nuevoProducto = new Invetario(0, nombre, 0, precio, "N/A", categoria);
            InvetarioDB.insertarProducto(nuevoProducto);

            System.out.println("\n--- Productos en base de datos ---");
            Mostrarproductos.MostrarProductos();

            // ACTUALIZAR PRODUCTO
            System.out.println("\n--- Actualizar producto ---");
            System.out.print("ID del producto a actualizar: ");
            int idActualizar = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = sc.nextLine();
            System.out.print("Nueva cantidad: ");
            int nuevaCantidad = sc.nextInt();
            System.out.print("Nuevo precio: ");
            double nuevoPrecio = sc.nextDouble();
            InvetarioDB.actualizarProducto(idActualizar, nuevoNombre, nuevaCantidad, nuevoPrecio);

            // ELIMINAR PRODUCTO
            System.out.println("\n--- Eliminar producto ---");
            System.out.print("ID del producto a eliminar: ");
            int idEliminar = sc.nextInt();
            InvetarioDB.eliminarProducto(idEliminar);
            conn.close();
        } else {
            System.out.println("\u274C No se pudo conectar a la base de datos.");
        
        
        
        
        
        
        }
    
    
    }
}



        


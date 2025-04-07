public class mein {
    public static void main(String[] args) throws Exception {
        try {
            // Cargar el driver JDBC (no conecta, solo verifica que existe)
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(" JDBC driver cargado exitosamente.");
        } catch (ClassNotFoundException e) {
            System.out.println(" No se pudo cargar el driver JDBC.");
            e.printStackTrace();
        }
    }
}

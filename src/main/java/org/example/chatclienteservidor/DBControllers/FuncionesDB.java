package org.example.chatclienteservidor.DBControllers;

import org.example.chatclienteservidor.Constantes;
import org.example.chatclienteservidor.Usuario;

import java.sql.*;

public class FuncionesDB {
    public static final String RUTA_BBDD ="jdbc:mysql://localhost:3306/ChatClienteServidor";
    public static Connection connection;
    private static Usuario usuarioApp;

    public static boolean conexion() {
        try {
            connection = DriverManager.getConnection(Constantes.RUTA_BBDD, Constantes.USUARIO_BBDD, Constantes.CONTRASEÑA_BBDD);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static boolean comprobarUsuario(String usuario, String contrasena) {
        conexion();
        // Sentencia SQL para buscar un usuario con el nombre de usuario y contraseña proporcionados
        String sentenciaSQL = "SELECT * FROM usuarios WHERE nombre=? AND contrasena=?";

        // Verifica que la conexión a la base de datos no sea nula
        if (connection != null) {
            try {
                // Preparación de la sentencia SQL con parámetros
                PreparedStatement sentencia = connection.prepareStatement(sentenciaSQL);
                sentencia.setString(2, usuario);  // Establece el valor del primer parámetro (nombreUsuario)
                sentencia.setString(3, contrasena); // Establece el valor del segundo parámetro (contrasena)

                // Ejecución de la consulta SQL y obtención del resultado
                ResultSet resultado = sentencia.executeQuery();

                // Comprueba si se encontró algún resultado en la consulta
                if (resultado.next()) {
                    // Si hay un resultado, crea un objeto Usuario con los datos obtenidos
                    usuarioApp = new Usuario(
                            resultado.getInt("id"),
                            resultado.getString("nombre"),
                            resultado.getString("contrasena")
                    );
                    System.out.println("Usuario encontrado");
                    // Devuelve true para indicar que la autenticación fue exitosa
                    return true;
                } else {
                    // Si no hay resultado, imprime un mensaje en la consola (puede ser útil para depuración)
                    System.out.println("Usuario no encontrado");
                }
            } catch (SQLException e) {
                // Captura cualquier excepción de SQL y devuelve false para indicar que la autenticación falló
                return false;
            }
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Si la conexión es nula o no se logró autenticar, devuelve false
        return false;

    }

    // Método que ingresa un nuevo usuario a la base de datos
    public static boolean ingresarUsuario(String nombre, String contrasena) {
        // Sentencia SQL para insertar un nuevo usuario en la tabla 'usuarios'
        String sql = "insert into usuarios(nombre,contrasena) values (?,?)";
        try {
            // Preparación de la sentencia SQL con parámetros
            PreparedStatement sentencia = connection.prepareStatement(sql);

            sentencia.setString(1, nombre);         // Establece el valor del primer parámetro (nombre)
            sentencia.setString(2, contrasena);     // Establece el valor del segundo parámetro (contrasena)



            // Ejecución de la inserción en la base de datos
            sentencia.execute();

            // Creación de un objeto Usuario con los datos proporcionados
            usuarioApp = new Usuario(0, nombre, contrasena);


        } catch (SQLException e) {
            // Captura cualquier excepción de SQL y devuelve false para indicar que la inserción falló
            return false;
        }

        // Devuelve true para indicar que la inserción del usuario fue exitosa
        return true;
    }





}

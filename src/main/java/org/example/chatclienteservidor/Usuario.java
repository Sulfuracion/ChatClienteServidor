package org.example.chatclienteservidor;

import java.io.Serializable;
/**
 * Clase que representa un usuario en el sistema.
 */
public class Usuario implements Serializable {

    private int id;

    private String nombre;
    private String Contaseña;

    /**
     * Constructor para la creación de un nuevo usuario.
     *
     * @param id            Identificador único del usuario.
     * @param nombre        Nombre del usuario.
     */

    public Usuario(int id, String nombre, String contaseña) {
        this.id = id;
        this.nombre = nombre;
        Contaseña = contaseña;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    /**
     * Método toString para obtener una representación en cadena del objeto Usuario.
     *
     * @return Cadena que representa al objeto Usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Contaseña='" + Contaseña + '\'' +
                '}';
    }
}
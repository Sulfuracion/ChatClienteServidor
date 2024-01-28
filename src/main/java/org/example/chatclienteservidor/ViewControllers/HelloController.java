package org.example.chatclienteservidor.ViewControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.chatclienteservidor.DBControllers.FuncionesDB;

import static org.example.chatclienteservidor.DBControllers.FuncionesDB.comprobarUsuario;

public class HelloController {
    FuncionesDB FDB;


    @FXML
    private Button AceptarButton;

    @FXML
    private Button CancelarButton;

    @FXML
    private PasswordField ContraseñaFlied;

    @FXML
    private Button ResgistrarseButton;

    @FXML
    private TextField UsuarioField;

    @FXML
    void AbrirRegistro(ActionEvent event) {

    }

    @FXML
    void CancelarInicioSesion(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void ComprarUsuario(ActionEvent event) {
        comprobarUsuario(UsuarioField.getText(), ContraseñaFlied.getText());

    }



    public PasswordField getContraseñaFlied() {
        return ContraseñaFlied;
    }



    public TextField getUsuarioField() {
        return UsuarioField;
    }


}

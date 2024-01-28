package org.example.chatclienteservidor.ViewControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static org.example.chatclienteservidor.DBControllers.FuncionesDB.ingresarUsuario;

public class RegistroController {

    @FXML
    private Button AceptarRegistroButton;

    @FXML
    private Button CancelarRegistroButton;

    @FXML
    private TextField ContraseñaRegistro;

    @FXML
    private TextField NombreRegistro;

    @FXML
    void CancelarRegistro(ActionEvent event) {

    }

    @FXML
    void ComprobarRegitroValido(ActionEvent event) {
        ingresarUsuario(NombreRegistro.getText(),ContraseñaRegistro.getText());

    }

}

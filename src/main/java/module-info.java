module org.example.chatclienteservidor {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;


    opens org.example.chatclienteservidor to javafx.fxml;
    exports org.example.chatclienteservidor;
    exports org.example.chatclienteservidor.ViewControllers;
    opens org.example.chatclienteservidor.ViewControllers to javafx.fxml;
}
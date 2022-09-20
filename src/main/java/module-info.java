module io.github.dbc.simplelogindemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens io.github.dbc.simplelogindemo to javafx.fxml;
    exports io.github.dbc.simplelogindemo;
}
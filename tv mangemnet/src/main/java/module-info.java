module org.example.tvmangemnet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.tvmangemnet to javafx.fxml;
    exports org.example.tvmangemnet;
}
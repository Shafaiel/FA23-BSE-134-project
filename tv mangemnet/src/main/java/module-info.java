module org.example.tvmangemnet {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tvmangemnet to javafx.fxml;
    exports org.example.tvmangemnet;
}
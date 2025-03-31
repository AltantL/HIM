module org.example.premierprojet1 {
    requires javafx.controls;
    requires javafx.fxml;

    exports vue;

    requires org.controlsfx.controls;

    opens org.example.premierprojet1 to javafx.fxml;
    exports org.example.premierprojet1;
}
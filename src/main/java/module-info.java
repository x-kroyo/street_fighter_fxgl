module com.kroyo.street_fighter_fxgl {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires spring.context;
    requires java.desktop;

    opens com.kroyo.street_fighter_fxgl to javafx.fxml;
    exports com.kroyo.street_fighter_fxgl;
}
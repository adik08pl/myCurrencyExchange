module com.stempien.mycurrencyexchange {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.json;

    opens com.stempien.mycurrencyexchange to javafx.fxml;
    exports com.stempien.mycurrencyexchange;
}
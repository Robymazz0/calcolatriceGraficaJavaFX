module com.mycompany.calcolatricegraficafinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.calcolatricegraficafinal to javafx.fxml;
    exports com.mycompany.calcolatricegraficafinal;
}

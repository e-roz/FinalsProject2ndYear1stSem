module com.example.finals_pharmacy {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.finals_pharmacy to javafx.fxml;
    exports com.example.finals_pharmacy;
}
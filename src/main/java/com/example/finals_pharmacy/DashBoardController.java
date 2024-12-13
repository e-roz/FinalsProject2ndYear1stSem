package com.example.finals_pharmacy;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {
    @FXML
    public AnchorPane leftPane;
    @FXML
    private AnchorPane scenePane;
    @FXML
    AnchorPane CRUDPane = new AnchorPane();
    @FXML
    private ChoiceBox <String> choiceType;
    @FXML
    private ChoiceBox <String> choiceStatus;

    private String [] status = {"available", "not-available"};


    private String[] medicine = {
            "Paracetamol", "Ibuprofen", "Aspirin",
            "Cough Syrup", "Decongestant", "Pain Relievers",
            "Antihistamines", "Antacids", "Laxatives",
            "Creams", "Ointments", "Lotions",
            "Antibiotics", "Antiviral Medications", "Antidepressants",
            "Antipsychotics", "Cardiovascular Medications", "Diabetes Medications",
            "Hormone Replacement Therapy (HRT)", "Cancer Medications",
            "Vaccines", "Vitamins", "Supplements",
            "Herbal Remedies", "Homeopathic Remedies"
    };
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            choiceType.getItems().addAll(medicine);
            choiceStatus.getItems().addAll(status);
            //-> inadd lang yung mga items sa string doon sa choiceBox


    }
}

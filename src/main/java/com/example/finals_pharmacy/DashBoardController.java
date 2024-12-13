package com.example.finals_pharmacy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {
    @FXML
    public AnchorPane leftPane;
    @FXML
    private AnchorPane scenePane;
    @FXML
    AnchorPane CRUDPane = new AnchorPane();
    @FXML
    private ChoiceBox<String> choiceType;
    @FXML
    private ChoiceBox<String> choiceStatus;
    @FXML
    private Button addBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private TableView<Medicine> inventoryTable;
    @FXML
    private TableColumn<Medicine, String> medicineIDColumn;
    @FXML
    private TableColumn<Medicine, String> brandNameColumn;
    @FXML
    private TableColumn<Medicine, String> productNameColumn;
    @FXML
    private TableColumn typeColumn;
    @FXML
    private TableColumn statusColumn;
    @FXML
    private TableColumn<Medicine, Double> priceColumn;
    @FXML
    TableColumn<Medicine, Double> quantityColumn;
    @FXML
    private TextField medicineIDField;
    @FXML
    private TextField brandField;
    @FXML
    private TextField productNameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField quantityField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //choiceType.getItems().addAll(medicine);
        //choiceStatus.getItems().addAll(status);
        //-> inadd lang yung mga items sa string doon sa choiceBox
        medicineIDColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("id"));
        brandNameColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("brandName"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("Quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("price"));
    }
    public void add(ActionEvent e) {
        Medicine medicine = new Medicine(medicineIDField.getText(),
                brandField.getText(), productNameField.getText(), Double.parseDouble(priceField.getText()),
                Double.parseDouble(quantityField.getText()));

        inventoryTable.getItems().add(medicine); //-> add the elements in the tableView node

        medicineIDField.clear();
        brandField.clear();
        productNameField.clear();
        priceField.clear();
        quantityField.clear();
    }
    public void remove(ActionEvent event){
        TableView.TableViewSelectionModel<Medicine> selectionModel = inventoryTable.getSelectionModel();
        if(selectionModel.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.show();
            alert.setHeaderText("Error deleting record.");
            alert.setContentText("Record not found.");
        }
        ObservableList<Integer> list = selectionModel.getSelectedIndices();
        Integer[] selectedIndices = new Integer[list.size()];
        selectedIndices = list.toArray(selectedIndices);
        Arrays.sort(selectedIndices);
        for(int i = selectedIndices.length - 1; i >= 0; i--){
            selectionModel.clearSelection(selectedIndices[i]);
            inventoryTable.getItems().remove(selectedIndices[i].intValue());
        }
    }
}

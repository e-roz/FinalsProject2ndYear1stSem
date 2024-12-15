package com.example.finals_pharmacy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {
    @FXML
    public PieChart pieChart;
    @FXML
    public AnchorPane leftPane;
    @FXML
    private AnchorPane scenePane;
    @FXML
    AnchorPane CRUDPane = new AnchorPane();
    @FXML
    private Button addBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private TableView<Medicine> inventoryTable;
    @FXML
    private TableColumn<Medicine, String> medicineIDColumn;
    @FXML
    private TableColumn<Medicine, String> brandNameColumn;
    @FXML
    private TableColumn<Medicine, String> productNameColumn;
    @FXML
    private TableColumn<Medicine, String> priceColumn;
    @FXML
    TableColumn<Medicine, String> quantityColumn;
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

    private Map<String, PieChart.Data> pieChartDataMap = new HashMap<>();
    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        medicineIDColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("id"));
        brandNameColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("brandName"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("price"));

        pieChart.setData(pieChartData);
        edit();
    }


    public void add(ActionEvent e) throws IOException {
        if(!medicineIDField.getText().isEmpty()|| !brandField.getText().isEmpty()|| !productNameField.getText().isEmpty()
                || !priceField.getText().isEmpty() ||! priceField.getText().isEmpty()){ //-> c n check kung kumpleto yung information na inilagay ng user. If not -> false.

            Medicine medicine = new Medicine(medicineIDField.getText(),
                    brandField.getText(), productNameField.getText(), priceField.getText(),
                    quantityField.getText());
            inventoryTable.getItems().add(medicine); //-> add the elements in the tableView node


            String combinedName = medicine.getBrandName() + " - " + medicine.getName();
            double quantity = Double.parseDouble(quantityField.getText()); // Handle potential parsing exceptions
            PieChart.Data data = new PieChart.Data(combinedName, quantity);
            pieChartData.add(data);
            pieChartDataMap.put(combinedName, data);

            medicineIDField.clear();
            brandField.clear();
            productNameField.clear();
            priceField.clear();
            quantityField.clear();

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Tanginamo");
            alert.show();
        }

    }


    public void remove(ActionEvent event) {
        TableView.TableViewSelectionModel<Medicine> selectionModel = inventoryTable.getSelectionModel();
        if (selectionModel.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("BOBO ka ba?");
            alert.setContentText("Pumili ka ng i d delete tanga ka ba");
            alert.show();
        } else {
            int selectedIndex = selectionModel.getSelectedIndex();
            Medicine medicine = inventoryTable.getItems().remove(selectedIndex);

            String combinedName = medicine.getBrandName() + " - " + medicine.getName();
            PieChart.Data dataToRemove = pieChartDataMap.remove(combinedName);
            if (dataToRemove != null) {
                pieChartData.remove(dataToRemove);
            }
        }
    }
    public void edit(){
        medicineIDColumn.setCellFactory(TextFieldTableCell.<Medicine>forTableColumn());
        medicineIDColumn.setOnEditCommit(event ->{
            Medicine medicine = event.getTableView().getItems().get(event.getTablePosition().getRow());
            medicine.setId(event.getNewValue());
        } );
        brandNameColumn.setCellFactory(TextFieldTableCell.<Medicine>forTableColumn());
        brandNameColumn.setOnEditCommit(event ->{
            Medicine medicine = event.getTableView().getItems().get(event.getTablePosition().getRow());
            medicine.setBrandName(event.getNewValue());
        } );
        productNameColumn.setCellFactory(TextFieldTableCell.<Medicine>forTableColumn());
        productNameColumn.setOnEditCommit(event ->{
            Medicine medicine = event.getTableView().getItems().get(event.getTablePosition().getRow());
            medicine.setName(event.getNewValue());
        } );
        priceColumn.setCellFactory(TextFieldTableCell.<Medicine>forTableColumn());
        priceColumn.setOnEditCommit(event ->{
            Medicine medicine = event.getTableView().getItems().get(event.getTablePosition().getRow());
            medicine.setId(String.valueOf(event.getNewValue()));
        } );
        quantityColumn.setCellFactory(TextFieldTableCell.<Medicine>forTableColumn());
        quantityColumn.setOnEditCommit(event ->{
            Medicine medicine = event.getTableView().getItems().get(event.getTablePosition().getRow());
            medicine.setId(event.getNewValue());
        } );


        productNameColumn.setOnEditCommit(event -> {
            Medicine medicine = event.getTableView().getItems().get(event.getTablePosition().getRow());
            String oldName = medicine.getBrandName() + " - " + medicine.getName();
            medicine.setName(event.getNewValue());
            String newName = medicine.getBrandName() + " - " + medicine.getName();

            PieChart.Data dataToUpdate = pieChartDataMap.get(oldName);
            if (dataToUpdate != null) {
                dataToUpdate.setName(newName);
                pieChartDataMap.put(newName, dataToUpdate);
                pieChartDataMap.remove(oldName);

            }
        });
    }

    }



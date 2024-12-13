package com.example.finals_pharmacy;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    Button loginBtn;
    @FXML
    Pane rightPane;
    @FXML
    TextField userNameField;
    @FXML
    PasswordField passwordField;

    @FXML
    ImageView melody;

    public void LogIn(ActionEvent event) {
        String userName = userNameField.getText();
        String password = passwordField.getText();

        if(checkCredentials(userName, password)){ // -> c n check kung tama yung credentials
            alert();// same sa if statement XD
        }else {
            try{
                FXMLLoader loader= new FXMLLoader(getClass().getResource("DashBoard.fxml")); // -> pupunta sa scence 2
                Parent root = loader.load();
                loader.getController();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (IOException e){
                System.out.println("error" +e.getMessage());
            }
        }
    }
    private static final Map<String, String> credentials = new HashMap<>();
    static { //-> admin credentials
        credentials.put("admin", "password");
    }
    public static boolean checkCredentials(String username, String password) {
        return !credentials.containsKey(username) || !credentials.get(username).equals(password);
    }

    public void alert(){
        Alert alert = new Alert(Alert.AlertType.ERROR); // error if wrong yung credentials na inilagay.
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Username or password");
        alert.setContentText("Please enter the correct both username and password.");
        userNameField.requestFocus();
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        TranslateTransition translate = new TranslateTransition();
        //RotateTransition rotate = new RotateTransition();
        //rotate.setNode(melody);
        translate.setNode(melody);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(250);
        translate.setAutoReverse(true);
        translate.play();
        /*rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.play();*/

    }
}
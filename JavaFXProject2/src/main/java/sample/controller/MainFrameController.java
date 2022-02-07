package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.regex.Pattern;

public class MainFrameController {

    @FXML
    private TextField addressField;

    @FXML
    private Button parseButton;

    @FXML
    void initialize() {

        parseButton.setOnAction(event -> {
            Pattern pattern = Pattern.compile(
                    "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"
            );
            String address = addressField.getText();

            if (address ==null ||
                    !pattern.matcher(address).matches()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Адресная строка пуста");
                alert.setTitle("Ошибка ввода");
                alert.showAndWait();
                return;
            }

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/StatisticsFrame.fxml"));

            try {
                loader.load();
            } catch (Exception exception) {
                return;
            }

            Parent root = loader.getRoot();
            StatisticsFrameController controller = loader.getController();
            controller.fillTable(address);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            stage.close();
        });

    }

}



package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class Main extends Application {

    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        URL location = getClass().getResource("/fxml/MainFrame.fxml");
        loader.setLocation(location);
        try {
            loader.load();
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
            return;
        }
        Parent root = loader.getRoot();
        primaryStage.setTitle("Приложение для парсинга страницы");
        primaryStage.setScene(new Scene(root,700,400));
        LOGGER.info("Открываем MainFrame");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

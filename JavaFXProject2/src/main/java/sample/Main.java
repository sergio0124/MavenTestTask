package sample;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.controller.MainFrameController;

public class Main extends Application {

  private Stage primaryStage;
  private AnchorPane rootLayout;
  private ObservableList listDog = FXCollections.observableArrayList();

  @Override
  public void start(Stage stage) throws Exception{
    primaryStage = stage;
    showBaseWindow();
  }

  public static void main(String[] args) {
    launch(args);
  }

  public void showBaseWindow() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Main.class.getResource("/fxml/MainFrame.fxml"));
      rootLayout = loader.load();
      Scene scene = new Scene(rootLayout);
      primaryStage.setScene(scene);
      MainFrameController controller = loader.getController();
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

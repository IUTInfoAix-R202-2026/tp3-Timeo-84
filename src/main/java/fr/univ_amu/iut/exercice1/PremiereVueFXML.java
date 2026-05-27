package fr.univ_amu.iut.exercice1;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PremiereVueFXML extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    // 1. Charger l'URL du fichier FXML
    URL url = getClass().getResource("PremiereVueFXML.fxml");

    // 2. Charger la vue
    Parent root = FXMLLoader.load(url);

    // 3. Créer la scène
    Scene scene = new Scene(root);

    // 4. Configurer la fenêtre
    primaryStage.setTitle("Première vue FXML");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}

package fr.univ_amu.iut.exercice2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CompteurController {

  private final IntegerProperty compteur = new SimpleIntegerProperty(0);

  @FXML private Label labelCompteur;
  @FXML private Button boutonIncrementer;
  @FXML private Button boutonDecrementer;
  @FXML private Button boutonReinitialiser;

  @FXML
  private void initialize() {
    // Lier le texte du label à la valeur du compteur (unidirectionnel).
    // Dès que compteur change, labelCompteur affiche la nouvelle valeur.
    labelCompteur.textProperty().bind(compteur.asString());
  }

  @FXML
  private void incrementer() {
    // Incrémente la valeur de la propriété compteur.
    compteur.set(compteur.get() + 1);
  }

  @FXML
  private void decrementer() {
    // Décrémente la valeur de la propriété compteur.
    compteur.set(compteur.get() - 1);
  }

  @FXML
  private void reinitialiser() {
    // Remet la propriété compteur à 0.
    compteur.set(0);
  }

  public int getCompteur() {
    return compteur.get();
  }
}

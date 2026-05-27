package fr.univ_amu.iut.exercice3;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FormulaireConnexionController {

  @FXML private TextField champIdentifiant;
  @FXML private PasswordField champMotDePasse;
  @FXML private Button boutonOk;
  @FXML private Button boutonAnnuler;
  @FXML private Label labelMessage;

  @FXML
  private void initialize() {
    champMotDePasse
        .editableProperty()
        .bind(Bindings.greaterThanOrEqual(champIdentifiant.textProperty().length(), 6));

    boutonAnnuler
        .disableProperty()
        .bind(
            champIdentifiant
                .textProperty()
                .isEmpty()
                .and(champMotDePasse.textProperty().isEmpty()));

    BooleanBinding motDePasseInvalide =
        new BooleanBinding() {
          {
            super.bind(champMotDePasse.textProperty());
          }

          @Override
          protected boolean computeValue() {
            String mdp = champMotDePasse.getText();

            return mdp.length() < 8
                || mdp.chars().noneMatch(Character::isUpperCase)
                || mdp.chars().noneMatch(Character::isDigit);
          }
        };

    boutonOk.disableProperty().bind(motDePasseInvalide);
  }

  @FXML
  private void valider() {
    String id = champIdentifiant.getText();
    String mdp = champMotDePasse.getText();

    String etoiles = "*".repeat(mdp.length());

    labelMessage.setText(id + " " + etoiles);
  }

  @FXML
  private void annuler() {
    champIdentifiant.setText("");
    champMotDePasse.setText("");
    labelMessage.setText("");
  }
}

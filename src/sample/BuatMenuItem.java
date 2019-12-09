package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

class BuatMenuItem {
    static void about_developer(){
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(BuatMenuItem.class.getResource("../layout/about_developer.fxml"));
            Parent root = loader.load();

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 400, 300));
            stage.resizableProperty().setValue(Boolean.FALSE);
            stage.setTitle("About Developer");
            stage.show();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    static void system_exit(){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Are you sure?");
        a.setContentText("Press OK to exit, otherwise press cancel");


        Optional<ButtonType> result = a.showAndWait();
        if (result.isPresent()){
            if (result.get() == ButtonType.OK){
                System.exit(0);
            }
        }

        a.show();
    }
}

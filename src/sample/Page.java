package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Page {
    @FXML
    MenuBar menubar;
    @FXML
    TextField username;
    @FXML
    AnchorPane parentAnchor;
    @FXML
    PasswordField password;
    @FXML
    Button masuk, signup;

    private void openSecondScene(){
        try {
            //Load second scene
            //AnchorPane loader = new FXMLLoader.load(this.getClass().getResource("../layout/page_another.fxml"));

            AnchorPane pnlOne = FXMLLoader.load(this.getClass().getResource("../layout/page_another.fxml"));
            parentAnchor.getChildren().add(pnlOne);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void initialize(){
        masuk.setOnAction(event -> {
            if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                openSecondScene();
            }else{
                Alert a = new Alert(Alert.AlertType.NONE, "Wrong password or username",ButtonType.APPLY);
                a.setTitle("Alert");
                a.show();
            }
        });

        Menu menu1 = new Menu("File");
        MenuItem item1 = new MenuItem("Exit");
        item1.setOnAction(event -> {
            BuatMenuItem.system_exit();
        });
        menu1.getItems().add(item1);

        menubar.getMenus().add(menu1);

        //Third
        Menu menu3 = new Menu("About");
        MenuItem item3 = new MenuItem("Developer");
        MenuItem item3_1 = new MenuItem("Software");
        item3.setOnAction(event -> {
            BuatMenuItem.about_developer();
        });
        menu3.getItems().add(item3_1);
        menu3.getItems().add(item3);

        menubar.getMenus().add(menu3);

    }
}

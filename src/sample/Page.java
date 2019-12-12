package sample;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import connection_utils.ConnectionUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;

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

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet;

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

    public void openRegisterScene(){
        FXMLLoader pnlOnes = new FXMLLoader(this.getClass().getResource("../layout/BuatRegister.fxml"));
        Parent root = null;
        try {
            root = pnlOnes.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Pendaftaran");
        stage.resizableProperty().setValue(false);
        stage.getIcons().add(new Image("drawable/inventory.png"));
        stage.show();
    }

    public void initialize(){
        connection = ConnectionUtils.createConnect();

        masuk.setOnAction(event -> {
            String usernames = username.getText();
            String passwordas = password.getText();
            if (!usernames.isEmpty() && !passwordas.isEmpty()){
                String sql_syntax = "SELECT nama_users, password_users FROM users_javaku WHERE nama_users = ? AND password_users = ?";

                try{
                    preparedStatement = (PreparedStatement) connection.prepareStatement(sql_syntax);
                    preparedStatement.setString(1, usernames);
                    preparedStatement.setString(2, passwordas);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()){
                        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Success, please login",ButtonType.OK);
                        a.setTitle("Information");
                        a.show();
                        openSecondScene();
                    }else{
                        Alert a = new Alert(Alert.AlertType.WARNING,"Please enter correct username and password",ButtonType.OK);
                        a.setTitle("Information");
                        a.show();
                    }
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.NONE, "Wrong password or username",ButtonType.APPLY);
                a.setTitle("Alert");
                a.show();
            }
        });

        signup.setOnAction(event -> {
            openRegisterScene();
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

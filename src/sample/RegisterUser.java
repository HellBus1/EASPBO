package sample;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import connection_utils.ConnectionUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegisterUser {

    @FXML
    MenuBar menubar;

    @FXML
    TextField usernames, passwords, password1;

    @FXML
    Button daftar, kembali;

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private boolean resultSet;

    public void initialize(){
        connection = ConnectionUtils.createConnect();


        kembali.setOnAction(event -> {
            Stage stage = (Stage) kembali.getScene().getWindow();
            // do what you have to do
            stage.close();
        });

        daftar.setOnAction(event -> {
            String user = usernames.getText();
            String passworda = passwords.getText();
            String repeat = password1.getText();

            if (!passworda.equals(repeat) && !passworda.isEmpty() && !repeat.isEmpty()){
                Alert a = new Alert(Alert.AlertType.WARNING,"Password not same",ButtonType.APPLY);
                a.setTitle("Warning");
                a.show();
            }else{
                if (!user.isEmpty() && !passworda.isEmpty()){
                    String sql_syntax = "INSERT INTO users_javaku(nama_users, password_users) VALUES(?, ?)";

                    try{
                        preparedStatement = (PreparedStatement) connection.prepareStatement(sql_syntax);
                        preparedStatement.setString(1, user);
                        preparedStatement.setString(2, passworda);
                        resultSet = preparedStatement.execute();
                        int count = preparedStatement.executeUpdate();
                        if (count > 0){
                            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Success, please login",ButtonType.OK);
                            a.setTitle("Information");
                            a.show();
                        }
                        connection.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
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

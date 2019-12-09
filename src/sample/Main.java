package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../layout/page_two.fxml"));
        primaryStage.setTitle("Simple Point of Sale");
        primaryStage.setIconified(true);
//        primaryStage.getIcons().add(new Image("../drawable/inventory.png"));
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        System.out.println("this is a test string");
        try (Stream<Path> walk = Files.walk(Paths.get(""))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());
    
            result.forEach(System.out::println);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        launch(args);
    }
}

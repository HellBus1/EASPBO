package sample;

import barang.BarangPojo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Page2 {
    @FXML
    MenuBar bars;
    @FXML
    TableView barangs;
    @FXML
    Button kasirinput;

    public void initialize(){
        Menu menu1 = new Menu("File");
        MenuItem item1 = new MenuItem("Exit");
        item1.setOnAction(event -> {
            BuatMenuItem.system_exit();
        });
        menu1.getItems().add(item1);

        bars.getMenus().add(menu1);

        //Third
        Menu menu3 = new Menu("About");
        MenuItem item3 = new MenuItem("Developer");
        MenuItem item3_1 = new MenuItem("Software");
        item3.setOnAction(event -> {
            BuatMenuItem.about_developer();
        });
        menu3.getItems().add(item3_1);
        menu3.getItems().add(item3);

        bars.getMenus().add(menu3);
        TableColumn codecolumn = new TableColumn("Kode Barang");
        codecolumn.prefWidthProperty().bind(barangs.widthProperty().multiply(0.25));
        codecolumn.setCellValueFactory(new PropertyValueFactory<>("kode_barang"));

        TableColumn barangcolumn = new TableColumn("Nama Barang");
        barangcolumn.prefWidthProperty().bind(barangs.widthProperty().multiply(0.25));
        barangcolumn.setCellValueFactory(new PropertyValueFactory<>("nama_barang"));

        TableColumn hargacolumn = new TableColumn("Harga Barang");
        hargacolumn.prefWidthProperty().bind(barangs.widthProperty().multiply(0.25));
        hargacolumn.setCellValueFactory(new PropertyValueFactory<>("harga_barang"));

        TableColumn satuancolumn = new TableColumn("Satuan Barang");
        satuancolumn.prefWidthProperty().bind(barangs.widthProperty().multiply(0.25));
        satuancolumn.setCellValueFactory(new PropertyValueFactory<>("satuan_barang"));

        barangs.getColumns().addAll(codecolumn, barangcolumn, hargacolumn, satuancolumn );

        BarangPojo barang1 = new BarangPojo("Cabai rawit", "A001", 10000, "Kg");
        BarangPojo barang2 = new BarangPojo("Bawang Putih", "A002", 5000, "Kg");
        BarangPojo barang3 = new BarangPojo("Bawang Merah", "A003", 4000, "Kg");
        BarangPojo barang4 = new BarangPojo("Gula Pasir", "A004", 11000, "Kg");
        BarangPojo barang5 = new BarangPojo("Kelapa", "A005", 10000, "Satuan angka");
        barangs.getItems().addAll(barang1, barang2, barang3, barang4, barang5);

        kasirinput.setOnAction(event -> {
            startBayar();
        });

    }

    private void startBayar(){
        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../layout/bayar.fxml"));
        try{
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 400, 400));
            stage.resizableProperty().setValue(false);
            stage.getIcons().add(new Image("drawable/inventory.png"));
            stage.show();
        }catch (Exception e){

        }
    }

}

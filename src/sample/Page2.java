package sample;

import barang.BarangPojo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Page2 {
    @FXML
    MenuBar bars;
    @FXML
    TableView barangs;
    @FXML
    Button kasirinput, daftarbarang;

    public List<BarangPojo> getBarangPojos() {
        return barangPojos;
    }

    List<BarangPojo> barangPojos;

    public void initialize(){
        barangPojos = new ArrayList<>();
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

        barangs.getColumns().addAll(codecolumn, barangcolumn, hargacolumn );


        BarangPojo barang1 = new BarangPojo("Cabai rawit", "A001", 10000);
        barangPojos.add(barang1);
        BarangPojo barang2 = new BarangPojo("Bawang Putih", "A002", 5000);
        barangPojos.add(barang2);
        BarangPojo barang3 = new BarangPojo("Bawang Merah", "A003", 4000);
        barangPojos.add(barang3);
        BarangPojo barang4 = new BarangPojo("Gula Pasir", "A004", 11000);
        barangPojos.add(barang4);
        BarangPojo barang5 = new BarangPojo("Kelapa", "A005", 10000);
        barangPojos.add(barang5);
        System.out.println("before barang");
        barangs.getItems().addAll(barangPojos);

        kasirinput.setOnAction(event -> {
            startBayar();
        });

        daftarbarang.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../layout/daftar_barang.fxml"));
            try{
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 400, 400));
                stage.resizableProperty().setValue(false);
                DaftarBarang controller =
                        loader.getController();
                controller.initData(this);
                stage.show();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    //c
    private void startBayar(){
        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../layout/bayar.fxml"));
        try{
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 400, 400));
            stage.resizableProperty().setValue(false);
            stage.getIcons().add(new Image("drawable/inventory.png"));
            BuatBayar controller =
                    loader.<BuatBayar>getController();
            controller.initData(this);

            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update untuk CRUD barang
    public void updateBarang(String... strings) {
        for(BarangPojo barangPojo : barangPojos) {
            if (barangPojo.getKode_barang().equals(strings[0])) {
                barangPojo.setNama_barang(strings[1]);
                barangPojo.setHarga_barang(Integer.parseInt(strings[2]));
                barangs.refresh();
                break;
            }
        }
    }

    //remove untuk CRUD barang
    public void removeBarang(String kode_barang) {
        for (BarangPojo barangPojo : barangPojos) {
            if (barangPojo.getKode_barang().equals(kode_barang)) {
                barangPojos.remove(barangPojo);
                barangs.getItems().clear();
                barangs.getItems().addAll(barangPojos);
                break;
            }
        }
    }

    //create untuk CRUD barang
    public void createBarang(String... strings) {
        //check for code and name duplicates
        for (BarangPojo barangPojo : barangPojos) {
            if (barangPojo.getKode_barang().equals(strings[0]) || barangPojo.getNama_barang().equals(strings[1])) {
                return;
            }
        }
        barangPojos.add(new BarangPojo(strings[1], strings[0], Integer.parseInt(strings[2])));
        barangs.getItems().clear();
        barangs.getItems().addAll(barangPojos);
    }

}

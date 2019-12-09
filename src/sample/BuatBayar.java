package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;

public class BuatBayar {
    @FXML
    TextField kodebarangs, namabarang, hargabarang, jumlahbarang, totalharga;

    @FXML
    Button cetak, total;

    public void initialize(){

        total.setOnAction(event -> {
            int harga_barang = Integer.parseInt(hargabarang.getText());
            int jumlah_barang = Integer.parseInt(jumlahbarang.getText());
            totalharga.setText(String.valueOf(harga_barang * jumlah_barang));
        });

        cetak.setOnAction(event -> {
            String kodebarang = kodebarangs.getText();
            String namabarangs = namabarang.getText();
            String hargabarangs = hargabarang.getText();
            String totalhargas = totalharga.getText();

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Nota : ");
            a.setContentText("Kode Barang : " + kodebarang + "\n" + "Nama Barang : " + namabarangs + "\n" +
                    "Harga Barang : " + hargabarangs + "\n" + "Total Harga : " + totalhargas);
            a.show();
        });
    }
}

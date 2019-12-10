package sample;

import barang.BarangPojo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class DaftarBarang {
    @FXML
    TextField kodebarang, namabarang, hargabarang;

    @FXML
    Button update, checkbarang, create, delete;

    Page2 page2;

    public void initialize(){
        checkbarang.setOnAction(event -> {
            String kode_barang = kodebarang.getText();
            checkBarang(kode_barang);
        });

        create.setOnAction(event -> {
            String kode_barang = kodebarang.getText();
            String nama_barang = namabarang.getText();
            String harga_barang = hargabarang.getText();
            page2.createBarang(kode_barang, nama_barang, harga_barang);
            kodebarang.setText("");
            namabarang.setText("");
            hargabarang.setText("");
        });

        update.setOnAction(event -> {
            String kode_barang = kodebarang.getText();
            String nama_barang = namabarang.getText();
            String harga_barang = hargabarang.getText();
            page2.updateBarang(kode_barang, nama_barang, harga_barang);
            kodebarang.setText("");
            namabarang.setText("");
            hargabarang.setText("");
        });

        delete.setOnAction(event -> {
            String kode_barang = kodebarang.getText();
            page2.removeBarang(kode_barang);
            kodebarang.setText("");
            namabarang.setText("");
            hargabarang.setText("");
        });


    }

    public void initData(Page2 page2) {
        this.page2 = page2;
    }

    private void checkBarang(String kodebarang) {
        for(BarangPojo barangPojo : page2.getBarangPojos()) {
            //Get nama dan harga dari barang
            if (barangPojo.getKode_barang().equals(kodebarang)) {
                namabarang.setText(barangPojo.getNama_barang());
                hargabarang.setText(String.valueOf(barangPojo.getHarga_barang()));
                break;
            }
        }
    }

}

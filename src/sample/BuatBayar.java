package sample;

import barang.BarangPojo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BuatBayar {
    @FXML
    TextField kodebarangs, namabarang, hargabarang, jumlahbarang, totalharga;

    @FXML
    Button cetak, checkbarang, tambahtransaksi;

    List<BarangPojo> barangPojos;

    private List<String[]> listTransaksi; //listBarang.get() will always contain kodeBarang, namaBarang, hargaBarang, jumlahBarang, totalHarga.

    public void initialize(){
        listTransaksi = new ArrayList<>();

        checkbarang.setOnAction(event -> {
            String kode_barang = kodebarangs.getText();
            int jumlah_barang = Integer.parseInt(jumlahbarang.getText());
            checkBarang(kode_barang, jumlah_barang);
        });

        tambahtransaksi.setOnAction(event -> {
            checkbarang.fire();
            String kode_barang = kodebarangs.getText();
            String jumlah_barang = jumlahbarang.getText();
            String nama_barang = namabarang.getText();
            String harga_barang = hargabarang.getText();
            String total_harga = totalharga.getText();
            listTransaksi.add(new String[]{kode_barang, nama_barang, harga_barang, jumlah_barang, total_harga});
            kodebarangs.setText("");
            jumlahbarang.setText("");
            namabarang.setText("");
            hargabarang.setText("");
            totalharga.setText("");
        });
 
        cetak.setOnAction(event -> {
            StringBuilder final_string = new StringBuilder();
            int jumlah_total_harga = 0;
            //build reciept bedasarkan item yang dibeli
            for (String[] items:listTransaksi) {
                String kodebarang = items[0];
                String namabarangs = items[1];
                String hargabarangs = items[2];
                String jumlahbarangs = items[3];
                String totalhargas = items[4];
                jumlah_total_harga += Integer.parseInt(totalhargas);
                final_string.append(kodebarang).append("\t").append(jumlahbarangs).append("\t").append(hargabarangs).append(" \t").append(totalhargas).append("\t").append(namabarangs).append("\n");
            }
            final_string.append("\nTotal Harga: ").append(jumlah_total_harga);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Nota : ");
            a.setContentText(final_string.toString());
            a.show();
            listTransaksi = new ArrayList<>();
        });

    }

    public void initData(Page2 page2) {
        this.barangPojos = page2.getBarangPojos();
    }

    private void checkBarang(String kodebarang, int jumlah_barang) {
        for(BarangPojo barangPojo : barangPojos) {
            //Get nama dan harga dari barang
            if (barangPojo.getKode_barang().equals(kodebarang)) {
                namabarang.setText(barangPojo.getNama_barang());
                hargabarang.setText(String.valueOf(barangPojo.getHarga_barang()));
                totalharga.setText(String.valueOf(jumlah_barang * barangPojo.getHarga_barang()));
                break;
            }
        }
    }
}

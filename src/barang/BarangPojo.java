package barang;

public class BarangPojo {
    private String nama_barang;
    private String kode_barang;
    private int harga_barang;


    public BarangPojo(String nama_barang, String kode_barang, int harga_barang) {
        this.nama_barang = nama_barang;
        this.kode_barang = kode_barang;
        this.harga_barang = harga_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public int getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(int harga_barang) {
        this.harga_barang = harga_barang;
    }
}

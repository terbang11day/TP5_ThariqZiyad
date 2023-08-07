/**
 * Product adalah kelas abstrak yang merepresentasikan produk dalam aplikasi ShyourBox.
 */
public abstract class Product {
    private String name;
    private int price;
    private int stock;

    /**
     * Konstruktor untuk membuat objek Product.
     *
     * @param name   Nama produk.
     * @param price  Harga produk.
     * @param stock  Stok produk.
     */
    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Mengembalikan nama produk.
     *
     * @return Nama produk.
     */
    public String getName() {
        return name;
    }

    /**
     * Mengembalikan harga produk.
     *
     * @return Harga produk.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Mengembalikan stok produk.
     *
     * @return Stok produk.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Mengatur stok produk.
     *
     * @param stock Stok produk yang akan diatur.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Metode abstrak untuk menghitung diskon berdasarkan kuantitas pembelian.
     *
     * @param quantity Kuantitas pembelian produk.
     * @return Jumlah diskon yang diberikan.
     */
    public abstract int checkDiscount(int quantity);
}

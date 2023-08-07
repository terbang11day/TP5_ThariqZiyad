/**
 * OrderItem adalah kelas yang merepresentasikan item dalam keranjang belanja.
 */
public class OrderItem {
    private Product product;
    private int quantity;

    /**
     * Konstruktor untuk membuat objek OrderItem.
     *
     * @param product  Produk yang dibeli.
     * @param quantity Kuantitas produk yang dibeli.
     */
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Menghitung harga akhir untuk item pembelian berdasarkan harga produk, kuantitas, dan diskon.
     *
     * @return Harga akhir untuk item pembelian.
     */
    public int getFinalPrice() {
        return product.getPrice() * quantity * (100 - product.checkDiscount(quantity)) / 100;
    }

    /**
     * Mengembalikan objek produk dari item pembelian.
     *
     * @return Objek produk dari item pembelian.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Mengembalikan kuantitas produk yang dibeli dalam item pembelian.
     *
     * @return Kuantitas produk yang dibeli.
     */
    public int getQuantity() {
        return quantity;
    }
}

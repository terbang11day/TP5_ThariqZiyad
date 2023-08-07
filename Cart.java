import java.util.ArrayList;
import java.util.List;

/**
 * Cart adalah kelas yang merepresentasikan keranjang belanja pelanggan.
 */
public class Cart {
    private Customer customer;
    private List<OrderItem> orderList;

    /**
     * Konstruktor untuk membuat objek Cart.
     *
     * @param customer Pelanggan yang memiliki keranjang belanja.
     */
    public Cart(Customer customer) {
        this.customer = customer;
        orderList = new ArrayList<>();
    }

    /**
     * Menambahkan item pembelian ke dalam keranjang belanja.
     *
     * @param orderItem Item pembelian yang ditambahkan ke keranjang.
     */
    public void addOrderItem(OrderItem orderItem) {
        orderList.add(orderItem);
    }

    /**
     * Menghitung total harga belanja di dalam keranjang.
     * Jika pelanggan premium dan total harga >= 300000, maka diberikan diskon 10%.
     *
     * @return Total harga belanja setelah diberikan diskon (jika berlaku).
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderList) {
            totalPrice += orderItem.getFinalPrice();
        }
        if (customer.isPremium() && totalPrice >= 300000) {
            totalPrice -= (totalPrice * 10 / 100);
        }
        return totalPrice;
    }

    /**
     * Mengembalikan objek pelanggan yang memiliki keranjang belanja.
     *
     * @return Objek pelanggan.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Mengembalikan daftar item pembelian dalam keranjang belanja.
     *
     * @return Daftar item pembelian.
     */
    public List<OrderItem> getOrderList() {
        return orderList;
    }
}

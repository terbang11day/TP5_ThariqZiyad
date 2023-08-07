/**
 * Customer adalah kelas yang merepresentasikan pelanggan dalam aplikasi ShyourBox.
 */
public class Customer {
    private String name;
    private boolean isPremium;

    /**
     * Konstruktor untuk membuat objek Customer.
     *
     * @param name      Nama pelanggan.
     * @param isPremium true jika pelanggan adalah premium, false jika bukan.
     */
    public Customer(String name, boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }

    /**
     * Mengembalikan nama pelanggan.
     *
     * @return Nama pelanggan.
     */
    public String getName() {
        return name;
    }

    /**
     * Memeriksa apakah pelanggan adalah pelanggan premium.
     *
     * @return true jika pelanggan premium, false jika tidak.
     */
    public boolean isPremium() {
        return isPremium;
    }
}

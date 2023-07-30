import java.util.ArrayList;
import java.util.Scanner;

public class ShyourBox {
    private ArrayList<Product> products;
    private ArrayList<Cart> carts;
    private ArrayList<Customer> customers;

    public static void main(String[] args) {
        // TODO: Input file

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Selamat datang di ShyourBox");
            System.out.println("Menu" +
                    "\n1. Cari Produk" +
                    "\n2. Beli Produk" +
                    "99. Keluar");
            System.out.print("Masukkan pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    break;

                case 2:

                    break;

                case 99:
                    System.out.println("Terima kasih telah menggunakan ShyourBox.");
                    printReceipt();
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }

        } while (true);
    }

    public Product searchProduct(String name) {
        return null;
    }

    public void buy() {

    }

    public void addProduct(String filename) {

    }

    public void addCustomer(String filename) {

    }

    public static void printReceipt() {

    }

}
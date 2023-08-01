import java.util.ArrayList;
import java.util.Scanner;

public class ShyourBox {
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Cart> carts = new ArrayList<Cart>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public static void main(String[] args) {
        System.out.println("Welcome to ShyourBox! Yuk beli jangan shy shy!");

        // Subject to change: file address.
        String productAddress = "input/daftarProduk.txt";
        String customerAddress = "input/daftarCustomer.txt";

        addProduct(productAddress);
        addCustomer(customerAddress);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu" +
                    "\n1. Beli Produk" +
                    "\n2. Cari Produk" +
                    "\n3. Print Struk" +
                    "\n0. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    buyProduct();
                    break;
                case 2:
                    System.out.print("Cari produk dengan nama: ");
                    String name = scanner.next();
                    searchProduct(name);
                    break;
                case 3:
                    printReceipt();
                    break;
                case 0:
                    System.out.println("Yay!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }

    /**
     * Method untuk membeli produk.
     */
    public static void buyProduct() {
        // TODO: Implement this method.
    }

    /**
     * Method untuk mencari produk berdasarkan nama.
     * 
     * @param name
     * @return
     */
    public static Product searchProduct(String name) {
        // TODO: Implement this method.
        return null;
    }

    /**
     * Method untuk menambahkan produk pada file txt ke dalam list produk.
     * 
     * @param fileAddress
     */
    public static void addProduct(String fileAddress) {
        // TODO: Implement this method.
    }

    /**
     * Method untuk menambahkan customer pada file txt ke dalam list customer.
     * 
     * @param fileAddress
     */
    public static void addCustomer(String fileAddress) {
        // TODO: Implement this method.
    }

    /**
     * Method untuk mencetak struk belanja pada file txt.
     */
    public static void printReceipt() {
        // TODO: Implement this method.
    }

}
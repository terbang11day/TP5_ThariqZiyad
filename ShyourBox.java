import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ShyourBox adalah aplikasi untuk pembelian produk dan pencetakan struk belanja.
 */
public class ShyourBox {
    private List<Product> productList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private List<Cart> cartList = new ArrayList<>();

    /**
     * Metode utama untuk menjalankan aplikasi ShyourBox.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam program ini).
     */
    public static void main(String[] args) {
        ShyourBox shyourBoxApp = new ShyourBox();
        System.out.println("Welcome to ShyourBox! Yuk beli jangan shy shy!");

        String productAddress = "input/daftarProduk.txt";
        String customerAddress = "input/daftarCustomer.txt";

        shyourBoxApp.addProduct(productAddress);
        shyourBoxApp.addCustomer(customerAddress);

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
            scanner.nextLine();  // membersihkan buffer

            switch (choice) {
                case 1:
                    shyourBoxApp.buyProduct();
                    break;
                case 2:
                    System.out.print("Cari produk dengan nama: ");
                    String name = scanner.nextLine();
                    Product foundProduct = shyourBoxApp.searchProduct(name);
                    if (foundProduct != null) {
                        System.out.println("Nama Produk: " + foundProduct.getName());
                        System.out.println("Harga: " + foundProduct.getPrice());
                        System.out.println("Stok: " + foundProduct.getStock());
                    } else {
                        System.out.println("Produk tidak ditemukan.");
                    }
                    break;
                case 3:
                    shyourBoxApp.printReceipt();
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
     * Metode untuk memproses pembelian produk oleh pelanggan.
     */
    public void buyProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(productList);
        System.out.println(customerList);

        System.out.print("Masukkan nama customer: ");
        String customerName = scanner.nextLine();

        Customer customer = findCustomer(customerName);
        if (customer == null) {
            System.out.println("Mohon maaf, customer atas nama " + customerName + " tidak terdaftar!");
            return;
        }

        System.out.println("====MASUKKAN ITEM KE KERANJANG====");
        Cart cart = new Cart(customer);
        boolean continueShopping = true;

        while (continueShopping) {
            System.out.print("Masukkan nama produk: ");
            String productName = scanner.nextLine();

            if (productName.equalsIgnoreCase("X")) {
                continueShopping = false;
            } else {
                Product product = searchProduct(productName);
                if (product != null) {
                    System.out.print("Masukkan Jumlah (kg): ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();  // membersihkan buffer

                    if (quantity <= product.getStock()) {
                        OrderItem orderItem = new OrderItem(product, quantity);
                        cart.addOrderItem(orderItem);
                        product.setStock(product.getStock() - quantity);
                        System.out.println("Produk Berhasil ditambahkan!");
                    } else {
                        System.out.println("Mohon maaf, stok tidak mencukupi!");
                    }
                } else {
                    System.out.println("Mohon maaf, produk tidak tersedia!");
                }
            }
        }

        cartList.add(cart);
        System.out.println("Terima kasih sudah berbelanja, " + customer.getName() + "!");
    }

    /**
     * Metode untuk mencari produk berdasarkan nama.
     *
     * @param name Nama produk yang dicari.
     * @return Objek Product jika ditemukan, atau null jika tidak ditemukan.
     */
    public Product searchProduct(String name) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Metode untuk mencari pelanggan berdasarkan nama.
     *
     * @param name Nama pelanggan yang dicari.
     * @return Objek Customer jika ditemukan, atau null jika tidak ditemukan.
     */
    public Customer findCustomer(String name) {
        for (Customer customer : customerList) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Metode untuk menambahkan produk ke daftar produk dari berkas.
     *
     * @param fileAddress Alamat berkas yang berisi informasi produk.
     */
    public void addProduct(String fileAddress) {
        try {
            File file = new File(fileAddress);
            Scanner scanner = new Scanner(file);
            int productCount = 0;
            int productFailcount = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] productInfo = line.split(", ");
                if (productInfo.length == 5) {
                    String type = productInfo[0];
                    String name = productInfo[1];
                    int price = Integer.parseInt(productInfo[2]);
                    int stock = Integer.parseInt(productInfo[3]);

                    if (type.equalsIgnoreCase("Fruit")) {
                        boolean isLocal = productInfo[4].equalsIgnoreCase("Lokal");
                        productList.add(new Fruit(name, price, stock, isLocal));
                    } else if (type.equalsIgnoreCase("Veggie")) {
                        boolean isOrganic = productInfo[4].equalsIgnoreCase("Organik");
                        productList.add(new Veggie(name, price, stock, isOrganic));
                    }
                    productCount++;
                } else {
                    productFailcount++;
                }
            }

            scanner.close();
            System.out.println("Berhasil menambahkan " + productCount + " product");
            System.out.println("Gagal  menambahkan " + productFailcount + " product");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: File not found.");
        }
    }

    /**
     * Metode untuk menambahkan pelanggan ke daftar pelanggan dari berkas.
     *
     * @param fileAddress Alamat berkas yang berisi informasi pelanggan.
     */
    public void addCustomer(String fileAddress) {
        try {
            File file = new File(fileAddress);
            Scanner scanner = new Scanner(file);
            int customerCount = 0;
            int customerFailCount = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] customerInfo = line.split(", ");
                if (customerInfo.length == 2) {
                    String name = customerInfo[0];
                    boolean isPremium = customerInfo[1].equalsIgnoreCase("Premium");
                    customerList.add(new Customer(name, isPremium));
                    customerCount++;
                } else {
                    customerFailCount++;
                }
            }

            scanner.close();
            System.out.println("Berhasil menambahkan  " + customerCount + " customers.");
            System.out.println("Gagal menambahkan  " + customerFailCount + " customers.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: File not found.");
        }
    }

    /**
     * Metode untuk mencetak struk belanja dari keranjang belanja.
     */
    public void printReceipt() {
        for (Cart cart : cartList) {
            System.out.println("=============================");
            System.out.println("Nama Customer: " + cart.getCustomer().getName());
            System.out.println("Daftar Belanja:");
            for (OrderItem orderItem : cart.getOrderList()) {
                System.out.println(
                        orderItem.getProduct().getName() + "  " + orderItem.getQuantity() + "kg  " +
                                orderItem.getFinalPrice()
                );
            }
            System.out.println("Total Perbelanjaan: " + cart.getTotalPrice());
            System.out.println("=============================");
        }
    }
}

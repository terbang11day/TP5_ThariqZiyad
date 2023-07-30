import java.util.ArrayList;

public class Cart {
    private Customer customer;
    private ArrayList<OrderItem> orderItems;

    Cart() {

    };

    public int getTotalPrice() {
        return 0;
    }


    // Paid status kenapa int di class diagram?
    public boolean getPaidStatus() {
        return false;
    }

    public void addOrderItem() {

    };
}

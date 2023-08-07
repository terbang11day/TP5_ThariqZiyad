import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CartTest {

    private Cart cart;
    private Customer regularCustomer;
    private Customer premiumCustomer;

    @Before
    public void setUp() {
        regularCustomer = new Customer("Regular Customer", false);
        premiumCustomer = new Customer("Premium Customer", true);
        cart = new Cart(regularCustomer);
    }

    @Test
    public void testAddOrderItem() {
        Product product = new Fruit("Bawang Brebes", 1000, 10, true);
        OrderItem orderItem = new OrderItem(product, 2);
        cart.addOrderItem(orderItem);

        assertEquals(1, cart.getOrderList().size());
    }

    @Test
    public void testGetTotalPriceRegularCustomer() {
        Product product1 = new Fruit("Bawang Brebes", 1000, 10, true);
        Product product2 = new Veggie("Jeruk Medan", 500, 5, true);

        cart.addOrderItem(new OrderItem(product1, 3));
        cart.addOrderItem(new OrderItem(product2, 2));

        assertEquals(3500, cart.getTotalPrice());
    }

    @Test
    public void testGetTotalPricePremiumCustomerWithDiscount() {
        cart = new Cart(premiumCustomer);

        Product product1 = new Fruit("Bawang Brebes", 1000, 10, true);
        Product product2 = new Veggie("Jeruk Medan", 500, 5, true);

        cart.addOrderItem(new OrderItem(product1, 5));
        cart.addOrderItem(new OrderItem(product2, 3));

        assertEquals(1350, cart.getTotalPrice());
    }

    @Test
    public void testGetTotalPricePremiumCustomerWithoutDiscount() {
        cart = new Cart(premiumCustomer);

        Product product1 = new Fruit("Bawang Brebes", 1000, 10, true);
        Product product2 = new Veggie("Jeruk Medan", 500, 5, true);

        cart.addOrderItem(new OrderItem(product1, 2));
        cart.addOrderItem(new OrderItem(product2, 1));

        assertEquals(2500, cart.getTotalPrice());
    }

    // Add more test cases as needed

}

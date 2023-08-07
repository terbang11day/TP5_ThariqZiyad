import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testGetName() {
        Customer customer = new Customer("John Doe", true);
        assertEquals("John Doe", customer.getName());
    }

    @Test
    public void testIsPremium() {
        Customer premiumCustomer = new Customer("Alice", true);
        Customer regularCustomer = new Customer("Bob", false);

        assertEquals(true, premiumCustomer.isPremium());
        assertEquals(false, regularCustomer.isPremium());
    }
}

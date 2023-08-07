import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderItemTest {

    private Product fruit;
    private Product veggie;

    @Before
    public void setUp() {
        fruit = new Fruit("Apple", 1000, 10, true);
        veggie = new Veggie("Carrot", 500, 5, true);
    }

    @Test
    public void testGetFinalPrice() {
        OrderItem orderItem1 = new OrderItem(fruit, 3);
        OrderItem orderItem2 = new OrderItem(veggie, 2);

        assertEquals(2400, orderItem1.getFinalPrice());
        assertEquals(1000, orderItem2.getFinalPrice());
    }

    @Test
    public void testGetProduct() {
        OrderItem orderItem = new OrderItem(fruit, 2);

        assertEquals(fruit, orderItem.getProduct());
    }

    @Test
    public void testGetQuantity() {
        OrderItem orderItem = new OrderItem(veggie, 5);

        assertEquals(5, orderItem.getQuantity());
    }


}

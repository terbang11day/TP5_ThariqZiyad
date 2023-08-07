import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    private class DummyProduct extends Product {
        public DummyProduct(String name, int price, int stock) {
            super(name, price, stock);
        }

        @Override
        public int checkDiscount(int quantity) {
            return 0;
        }
    }

    private DummyProduct product;

    @Before
    public void setUp() {
        product = new DummyProduct("Dummy Product", 1000, 10);
    }

    @Test
    public void testGetName() {
        assertEquals("Dummy Product", product.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(1000, product.getPrice());
    }

    @Test
    public void testGetStock() {
        assertEquals(10, product.getStock());
    }

    @Test
    public void testSetStock() {
        product.setStock(5);
        assertEquals(5, product.getStock());
    }

    // Add more test cases as needed

}

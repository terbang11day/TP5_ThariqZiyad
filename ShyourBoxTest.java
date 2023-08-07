import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ShyourBoxTest {

    private ShyourBox shyourBox;

    @Before
    public void setUp() {
        shyourBox = new ShyourBox();
        // Inisialisasi data produk dan pelanggan untuk pengujian
        shyourBox.addProduct("test/products.txt");
        shyourBox.addCustomer("test/customers.txt");
    }

    @Test
    public void testSearchProduct() {
        Product foundProduct = shyourBox.searchProduct("Jeruk Medan");
        assertNotNull(foundProduct);
        assertEquals("Jeruk Medan", foundProduct.getName());
    }

    @Test
    public void testSearchNonExistentProduct() {
        Product foundProduct = shyourBox.searchProduct("NonExistentProduct");
        assertNull(foundProduct);
    }

    @Test
    public void testFindCustomer() {
        Customer foundCustomer = shyourBox.findCustomer("Fajar Silalahi");
        assertNotNull(foundCustomer);
        assertEquals("Fajar Silalahi", foundCustomer.getName());
    }

    @Test
    public void testFindNonExistentCustomer() {
        Customer foundCustomer = shyourBox.findCustomer("NonExistentCustomer");
        assertNull(foundCustomer);
    }


}

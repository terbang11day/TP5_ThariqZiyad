import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FruitTest {

    private Fruit localFruit;
    private Fruit importedFruit;

    @Before
    public void setUp() {
        localFruit = new Fruit("Jeruk Medan", 1000, 10, true);
        importedFruit = new Fruit("Bawang Brebes", 1500, 8, false);
    }

    @Test
    public void testCheckDiscountLocalFruit() {
        assertEquals(30, localFruit.checkDiscount(5));
        assertEquals(20, localFruit.checkDiscount(4));
        assertEquals(20, localFruit.checkDiscount(3));
        assertEquals(0, localFruit.checkDiscount(2));
    }

    @Test
    public void testCheckDiscountImportedFruit() {
        assertEquals(20, importedFruit.checkDiscount(5));
        assertEquals(15, importedFruit.checkDiscount(4));
        assertEquals(15, importedFruit.checkDiscount(3));
        assertEquals(0, importedFruit.checkDiscount(2));
    }

}
